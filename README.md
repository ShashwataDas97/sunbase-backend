# SunBase Backend Project
 
## Assignment Project 
 
This repository houses the backend API codebase for customer information management, focusing on CRUD operations. Phase two will enhance functionality by integrating synchronization with a remote API to ensure up-to-date customer data.
 
### Assignment Completion
 
The following API endpoints have been implemented in the initial phase:
In my case I use http://localhost:8080/home then api end point
 
1. **To Create a New Customer**
   - Method: POST
   - Path: `/api/customers`
   - Description: Create a new customer in the system.
 
2. **To Update a Customer**
   - Method: PUT
   - Path: `/api/customers/{customerId}`
   - Description: Update an existing customer's information.
 
3. **To Get a List of Customers**
   - Method: GET
   - Path: `/api/customers`
   - Description: Retrieve a paginated, sorted, and searchable list of customers.
 
4. **To Get a Single Customer Based on ID**
   - Method: GET
   - Path: `/api/customers/{customerId}`
   - Description: Retrieve details of a specific customer based on their ID.
 
5. **To Delete a Customer**
   - Method: DELETE
   - Path: `/api/customers/{customerId}`
   - Description: Delete a customer from the system.
  
6. **To Serach a Cutomer by Name, Email, State etc**
   - Method: GET
   - Path: `/api/customers/search`
   - Description: Serach a Cutomer by Name, Email, State, City.
  
1st Screen ( **Login Page**)
![login](https://github.com/ShashwataDas97/sunbase-backend/assets/142168847/dc215cba-9349-4ff2-8273-d600558f43c7)

2nd Screen (**Customer Details with edit and delete button**)
![list-page](https://github.com/ShashwataDas97/sunbase-backend/assets/142168847/73209080-82ef-45f1-845a-402ebf173b51)
 
3rd Screen (**Adding a customer**)
![add](https://github.com/ShashwataDas97/sunbase-backend/assets/142168847/2aec3651-396a-478a-bddd-0293ed8c291d)

### Second Phase
 
In the second phase, additional functionality has been added :
 
- **Synchronize Customer List**
  - Description: On the customer list screen, a "Sync" button has been incorporated. When activated, it initiates an API call to a remote server, fetching the latest customer data. These retrieved entries are subsequently stored in the local database. In case of existing customers, their information undergoes updates instead of creating duplicate records. To execute this feature, you can either download the frontend repository or utilize Postman with the provided endpoint (**for postman**:http://localhost:8080/home/api/customers/search/sunbase)
 
- **Frontend Code Link**
  - https://github.com/ayushraj12009/sunBaseFrontend.git
 
### Setup and Usage
 
1. Clone the repository.
2. Set up the backend environment.
3. Create a database named "sunbaseDB".
4. Run the backend server.
5. Clone the fronted code.
6. Run the frontend code.
