# List-database-Data-on-web-page
Dynamic Web page Developed in java using java Servlet, JSP and Hibernate.
This application is working with MySql database, where the the data is stored consisting of Student information:
  - user_id
  - username
  - email
  - first_name
  - second_name
The frontend is developed using JSP which imports the css and html files.
Beckend hasbeen done in servlets and java.
The whole application functions as follows:
  1. Running the application will view the index.jsp configured in web.xml with <welcome-file> tag.
  2. The index view has three tabs HOME, LIST USERTYPE, ADDUSERS.
  3. The index page has some information displayed about HOME Page.
  4. Clicking HOME tag will redirect to same index page ie. home page
  5. There are total of 6 pages named addUser, deleteUser, error, index, listUser, updateUser, include/header and include/footer.
  6. Header and footer pages are taken from open source free websites and updated to use in this application.
  7. All these pages are controlled by OperationController Servlet.
      #Clicking On AddUser tab redirect to ADD_USER_FORM page where you will be asked to enter the username and email to add a new user:
          - Onclicking the Add User button the post request will go to the controller and there the user will be added to the database.
          - This application is using MYSQL database.
          
      #Clicking the List UserType redirects to LIST_USER_FORM page.
          - Here In this page the users will be listed down with an additional option to Update and delete the user in dataBase
          - clicking the update user will redirect to a page for updation and delete page will redirect to delete page,
            Both these pages are controlled by controller page which comes into picture on post call from update and delete prompt.
   8. Controller here is the one which will be contol the get and post method calls from these pages.
   
   9. There is a entity file which stores the database table rows as an object in application and connection with database happens in model layer.
