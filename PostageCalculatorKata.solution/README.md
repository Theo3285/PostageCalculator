# Refactoring Technique

## Calculator class
The two private methods postageInBaseCurrency() and convertCurrency() indicate a responsibility code smell.
It has several reason to change hence does comply with the Single Responsibility Principle.
The PostageInBaseCurrency() private method also has a Long Parameter List code smell
 
 Looking at the parameters, they're related to dimensions and reused in the body of the method
 that indicates a Data Clump code smell.
 
 * 1. Extract dimension parameters using Extract Class refactoring in the private method but not the public
    method because it will affect Calculator clients' class.
 * 2. Make package dimension fields private and immutable without getters.
 * 3. Move postageInBaseCurrency() method (Feature Envy) to the Package Class and make it public
 * 4. Update postageInBaseCurrency member in calculate method so it creates a new package and call now the public method
 
## Package class
Looking at the postageInBaseCurrency() method, it has 3 if statements and returns which is close to a Switch
Statement code smell. The method does not comply with the Open Close Principle since a new size will require
a modification of the class.
  
  * 1. Start with Decomposing Conditional and move conditions into isSmall() and isMedium() methods
  * 2. Extract returns into small, medium and largePackagePostageInCurrency() methods.
  
This refactoring brings a new pattern: There is three types of package : small, medium and large.
We can now extract each type in its own class with Polymorphism and following Liskov substitution principle.
  
  * 1. Create a SmallPackage class and move the smallPackagePostageInCurrency() method into it. Make the method public
     and static.
  * 2. We need to do the same for the mediumPackagePostageInCurrency() method but this one is having a reference to the
     weight field. 
     * a. Pass the weight reference as a method parameter
     * b. Create a MediumPackage class
     * c. This time create an immutable weight property and a constructor that takes the weight in the MediumPackage
        class
     * d. Move the mediumPackagePostageInCurrency() into the MediumPackage class and change its signature to return an
        int
     * e. Change the return statement in the isMedium() condition so it creates a new MediumPackage(this.weight) and calls
        mediumPackagePostageInCurrency() method. 
  * 3. We do the same with largePackagePostageInCurrency().
     Now that these method are isolated in their own type we can change their name to PostageInCurrency() so all types
     are alike and more polymorphous.
  * 4. Looking at the postageInCurrency() method calls, the SmallPackage one is a static method call. Let's make it an instance call
     instead.

Now looking at the postageInBaseCurrency() method, we can see some duplicated logic since the same method is called
on each condition. We need to introduce an Abstraction and follow the Dependency Inversion Principle.

  * 1. Seperate the creation of the package from the invocation of the postageInBaseCurrency() method
  
     * a. Create an Abstraction of the Package types using SamllPackage class by extracting an Interface name SizedPackage.
        Package would be a better naming but it is used already.
     * b. Make postageInBaseCurrency() method in small, medium and Large Packages return a double
     * c. Extract the content of postageInBaseCurrency() method into a method call createSizedPackage() method and make
        in return an int. Now the postageInBaseCurrency() method only contains "return createSizedPackage()"
     * d. Move the postageInBaseCurrency() method call from each return statement and append it to the createSizedPackage()
        Make that last method return a SizedPackage instead of int, fixing the compilation failure

Now the package class has 2 responsibilities. 1 is the creation of the package and the other is invocation of
the postageInBaseCurrency() method. The creation is acting as a collaborator.

  * 1. Move the creation onto the package constructor and make the SizedPackage an immutable field of the Package class
  
Now dimension fields (weight, height, width and depth) are Temporary Fields smell. They're passed in the constructor
and then used in the createSizedPackage(), isSmall() and isMedium() methods only.
  
  * 1. Make the isSmall() method static and pass the dimension fields as parameters. Update the method call in the
     createSizedPAckage() method accordingly
  * 2. Do the same with isMedium() and createSizedPackage() methods.
  * 3. Remove now the dimension fields from the constructor and the Package class.

The package still has both responsibilities. createSizedPackage() should be moved within a Static Factory method in
an abstraction class.
  
  * 1. Convert the SizedPackage interface to an abstract class.
  * 2. Add the Override annotation to the postageInBaseCurrency() implementations
  * 3. Move the createSizedPackage(), isSmall() and isMedium() methods onto the new abstract class.
  * 4. Rename createSizedPackage() withDimensions() to make it more descriptive (read like a book).

The Package class is now violating the Dependency Inversion Principle because knows how to create its collaborator.
  
  * 1. Pass the abstraction as a parameter of the Package constructor
  * 2. Remove the dimension parameters from the constructor

Now the Package class is no longer doing anything and is now a middleman code smell
  
  * 1. Remove the new package instantiation from the calculator
  * 2. Delete the package class
  * 3. Rename the abstract SizedPackage to Package
  * 4. Extract a package variable in the Calculator to clarify what is happening
