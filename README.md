![image](https://github.com/Vidhi093/student-management-system/assets/149268685/27640685-d396-40d9-b8ac-7ad8ed9ec923)
![image](https://github.com/Vidhi093/student-management-system/assets/149268685/56c4206e-ce7a-496b-a4a2-0284fb8a2e33)
![image](https://github.com/Vidhi093/student-management-system/assets/149268685/17bdfe7b-492c-476c-8916-9502fcef71d9)
![image](https://github.com/Vidhi093/student-management-system/assets/149268685/1a3116f6-ada6-48f8-a160-28bfe2c130b5)
![image](https://github.com/Vidhi093/student-management-system/assets/149268685/51e6d7be-6892-4c1e-b882-3e6c9b53e570)
![image](https://github.com/Vidhi093/student-management-system/assets/149268685/4d38168f-7bfd-4465-844c-a761930efefe)


### 1. LoginServlet

#### Purpose:
The `LoginServlet` handles the user login functionality within a web application. It receives user credentials (username and password) from an HTML form, validates them using a `StudentController`, and redirects the user accordingly.

#### Key Points:
- **URL Mapping**: The servlet is mapped to the "/login" URL, and it loads on startup.
- **Method**: Uses the `doPost` method to handle HTTP POST requests.
- **Validation**: Validates user credentials using a `StudentController` to authenticate.
- **Redirection**: Redirects to "welcome.jsp" upon successful login; otherwise, redirects to the login page with an error message.

### 2. UpdateServlet

#### Purpose:
The `UpdateServlet` manages the process of updating user details. It retrieves updated information (address) from an HTML form, verifies the user's identity, and updates the details in the system.

#### Key Points:
- **URL Mapping**: The servlet is mapped to the "/update" URL.
- **Method**: Uses the `doGet` method to handle HTTP GET requests.
- **Update Logic**: Retrieves user input, finds the corresponding student using a `StudentController`, and updates the address if the provided password is correct.
- **Response**: Returns a success message in HTML format upon a successful update, and an error message if the credentials are invalid.

### 3. ForgetPassword

#### Purpose:
The `ForgetPassword` servlet allows users to change their passwords. It receives a new password and confirmation from an HTML form, validates them, and updates the user's password through a `StudentController`.

#### Key Points:
- **URL Mapping**: The servlet is mapped to the "/changePassword" URL, loading on startup.
- **Method**: Uses the `doGet` method to handle HTTP GET requests.
- **Validation**: Validates the new password and confirmation, changes the password if valid, and provides appropriate feedback.

### 4. DeleteServlet

#### Purpose:
The `DeleteServlet` manages the deletion of user accounts. It receives user credentials, verifies them using a `StudentController`, and deletes the account if the credentials are valid.

#### Key Points:
- **URL Mapping**: The servlet is mapped to the "/delete" URL.
- **Method**: Uses the `doGet` method to handle HTTP GET requests.
- **Deletion Logic**: Retrieves user input, finds the corresponding student, and deletes the account if the provided password is correct.
- **Response**: Returns a success message in HTML format upon a successful deletion, and an error message if the credentials are invalid.

### 5. View

#### Purpose:
The `View` servlet retrieves and displays user details. It finds the student based on the provided username and forwards the request to a JSP page for rendering.

#### Key Points:
- **URL Mapping**: The servlet is mapped to the "/view" URL.
- **Method**: Uses the `doGet` method to handle HTTP GET requests.
- **Find Student**: Retrieves user input, finds the corresponding student using a `StudentController`, and forwards the request to a JSP page for rendering.
- **Response**: Displays user details on the JSP page or an error message if the credentials are invalid.

### 6. web.xml (Deployment Descriptor)

#### Purpose:
The `web.xml` file serves as the deployment descriptor for the web application. It configures the welcome file to be "loginform.html."

#### Key Points:
- **Welcome File**: Configures "loginform.html" as the welcome file for the web application.

### 7. HTML Files

#### Purpose:
Various HTML files (e.g., deleteform.html, forgetpassword.html, etc.) are used for user input and interaction with the servlets.

#### Key Points:
- **User Interaction**: Provides forms for user input related to account actions (update, delete, change password, etc.).

### Student Model (`Student` class)

#### Purpose:
The `Student` model represents the data structure for storing information related to a student, such as username, password, address, etc.

#### Key Points:
- **Attributes**: Typically includes fields like `username`, `password`, `address`, and any other relevant information.
- **Getters and Setters**: Provides methods to access and modify the attributes.

### 8.StudentController

#### Purpose:
The `StudentController` acts as an intermediary between the servlets and the database. It contains methods to perform operations such as finding a student, updating student details, changing passwords, deleting accounts, etc.

#### Key Points:
- **Database Interaction**: Contains methods to interact with a database, such as connecting to the database, executing queries, and updating records.
- **Business Logic**: Implements business logic related to student operations (e.g., authentication, validation).
- **Error Handling**: Manages exceptions that may occur during database operations.

## 9. `RegisterServlet`

### Purpose
The `RegisterServlet` is responsible for handling user registration requests. It processes the information submitted by the user through the registration form, creates a new `Student` object, and attempts to register the student by interacting with the `StudentController`.

### Methods

#### `doGet` Method
- **Purpose**: Handles HTTP GET requests.
- **Parameters**:
  - `HttpServletRequest req`: Represents the request made by the client.
  - `HttpServletResponse resp`: Represents the response that will be sent to the client.
- **Functionality**:
  - Retrieves user registration details from the request parameters (name, email, contact, password, username, address, branch, gender).
  - Creates a new `Student` object with the retrieved information.
  - Invokes the `registerStudent` method from the `StudentController` to attempt student registration.
  - Generates HTML response based on the registration result and sends it to the client.

### HTML Response
- The servlet generates different HTML responses based on the outcome of the registration attempt.
- Three possible outcomes:
  1. **Registration Successful**: Displays a success message with a link to the login page.
  2. **User Already Present**: Notifies the user that the entered username is already taken, providing a link to the login page.
  3. **Invalid Credentials**: Displays a message indicating that the registration was not successful and provides a link to the registration page.

### Usage
- The servlet is mapped to the `/register` URL through the `@WebServlet` annotation.
- It is expected to be accessed via an HTTP GET request, typically triggered by a user submitting the registration form.

## 10. `Database` Servlet

### Purpose
The `Database` servlet is responsible for managing the connection to the database using Java Persistence API (JPA). It initializes the `EntityManagerFactory`, `EntityManager`, and `EntityTransaction` objects during the application startup, ensuring that the database connection is established and available for use.

### Methods

#### Constructor
- **Purpose**: Initializes the servlet and prints a message indicating that the database is connected.
- **Functionality**: 
  - Creates an instance of the `Database` servlet.
  - Prints a message to the console indicating that the database is connected.

### Fields

#### `entityManagerFactory`
- **Type**: `EntityManagerFactory`
- **Purpose**: Represents the JPA entity manager factory, used for creating `EntityManager` instances.
- **Initialization**: Created using `Persistence.createEntityManagerFactory("pgadmin")`.

#### `entityManager`
- **Type**: `EntityManager`
- **Purpose**: Represents the JPA entity manager, used for database operations.
- **Initialization**: Created using `entityManagerFactory.createEntityManager()`.

#### `entityTransaction`
- **Type**: `EntityTransaction`
- **Purpose**: Represents the JPA entity transaction, used for managing transactions.
- **Initialization**: Created using `entityManager.getTransaction()`.

### Annotations

#### `@WebServlet`
- **Purpose**: Indicates that this class is a servlet and specifies its configuration.
- **Attributes**:
  - `value`: Specifies the URL pattern for accessing the servlet (`/DB`).
  - `loadOnStartup`: Specifies that the servlet should be loaded on application startup (`1`).

### Database Connection
- The servlet establishes a connection to the database named "pgadmin" using JPA.
- The database connection details, such as the database name and other configurations, are specified in the persistence unit configuration.

### Usage
- This servlet is automatically loaded on application startup due to the `loadOnStartup` attribute in the `@WebServlet` annotation.
- The initialization of `EntityManagerFactory`, `EntityManager`, and `EntityTransaction` ensures that the database connection is ready for use throughout the application's lifecycle.
