B.  Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
- src/main/resources/templates/mainscreen.html
lines: 13,16,21
- src/main/resources/static/css/demo.css
Lines: 1-3

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
- Added src/main/java/com/example/demo/controllers/AboutController.java
- Added src/main/resources/templates/about.html
- src/main/resources/templates/mainscreen.html Lines 21 - 36

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
- src/main/java/com/example/demo/bootstrap/BootStrapData.java Lines 45-126
- src/main/resources/application.properties Line 6

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.
- src/main/java/com/example/demo/controllers/AddPartController.java Lines: 68-83
- src/main/java/com/example/demo/controllers/AddProductController.java Lines: 130-148
- src/main/resources/templates/mainscreen.html lines -38-96

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.
- src/main/java/com/example/demo/bootstrap/BootStrapData.java Lines: 67-134
- src/main/java/com/example/demo/domain/Part.java Lines 34-76
- New File src/main/java/com/example/demo/validators/InventoryValidator.java
- New File src/main/java/com/example/demo/validators/ValidInventory.java
- New File src/main/resources/templates/Failure.html
- src/main/resources/templates/InhousePartForm.html Lines 25-35
- src/main/resources/templates/OutsourcedPartForm.html Lines 35-38
- new File src/main/resources/templates/Success.html

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.
- src/main/resources/templates/productForm.html Lines 23-32
- New File src/main/java/com/example/demo/validators/InventoryProductValidator.java
- src/main/java/com/example/demo/domain/Product.java Lines 33-72

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
- src/test/java/com/example/demo/domain/PartTest.java Lines: 160-178

J.  Remove the class files for any unused validators in order to clean your code.
- Removed src/main/java/com/example/demo/validators/DeletePartValidator.java