# FPT_Software_Entrance_Test

Functional Requirement
Develop an application for the problem described above. Simulate the following functionalities:

1. Create a customer
2. Create one order for a specific customer.
3. Edit a customer with specific data (name, address, phone)
4. Search order info by customer id

Entity Relationship Constraints
Assume that the relationship between the objects in the system is described as:

– Customer – Order (1 – N)
– Order – Product (1 - 1)
– Stock – Product (1 – 1)

Validation Constraints

– Customer name is not allowed to be null or empty.
– Phone number must be in correct format (for example, 0978325511 or 097.832.5511)
– The order amount must be in positive number.
– The order date must be in the format: dd/mm/yyyy.
– The order date cannot be less than the current date.

UI
- The candidates can freely build a simple GUI (console, desktop, or web app) so that it can meet the
requirements of the problem.

Testing
- All functionalities should be tested to make sure that they work well and meet the system requirements.
- It should be convenient if the system functionalities are automatically tested by using testing framework
like Junit.

Data Storage
- Data can be stored in a collection, file, or any relational database system such as SQL Server, MySQL,
or PostgreSQL...
- The candidates can choose any suitable data structure to solve the requirements.

Assessment Criteria:
The program must be successfully compiled without any errors and satisfy the following aspects:
- Functional Requirements: all functionalities must work properly; there is no error during the
execution of the program.
- Graphical User Interface: the program must provide a friendly UI so that the user can easily interact
with the application. The system UI might be built based on a console UI, window form, or web form.
Data must be validated based on validation constraints described above.
- Unit Testing: the core business functionalities must be tested using testing framework like Junit to
make sure that they meet the system requirements.
- Coding Standards: Java coding conventions must be applied (naming convention, code format,
comments in code...).
- Application structure: the application should be built based on any types of software architecture
patterns such as MVC, 3-layer, or client-server architecture.
- Program structure: the program must be well-organized followed OOP approach (class design,
method design, package structure, the paradigms of OOD & OOP must be effectively applied to
constructing the application.
