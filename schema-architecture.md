Architecture summary: This Spring Boot application uses both MVC and REST controllers. Thymeleaf templates are used for the Admin and Doctor dashboards, while REST APIs serve all other modules. 
The application interacts with two databases—MySQL (for patient, doctor, appointment, and admin data) and MongoDB (for prescriptions). 
All controllers route requests through a common service layer, which in turn delegates to the appropriate repositories. 
MySQL uses JPA entities while MongoDB uses document models.

Numbered flow of data and control: 
1. User accesses AdminDashboard or Appointment pages.
2. The action is routed to the appropriate Thymeleaf or REST controller.
3. The controller calls a method in the service layer to perform the requested business logic.
4. The service layer, which contains the core business logic, calls the data access layer (often using a repository pattern) to perform database operations, such as creating, reading, updating, or deleting data (CRUD operations).
5. The data access or repository layer executes the necessary commands to interact with the database.
6. The database executes the requested operation (e.g., a SQL query).
7. The database returns the result of the operation (the requested data) back to the repository.
8. The repository returns the retrieved data to the service layer.
9. The service performs any remaining business logic, then passes the data back to the controller.
10. Controller Prepares and Renders View: The controller processes the data received from the service layer.
11. For a Thymeleaf controller: It populates a model with the data and selects the appropriate view (HTML template) to render.
12. For a REST controller: It formats the data, typically into a JSON or XML payload, and includes the appropriate HTTP status code.
13. Response Sent to User: The server sends the rendered HTML page (for Thymeleaf) or the data payload (for REST) back to the user's browser, completing the cycle. 
