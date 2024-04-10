# spring-cache
A simple project to kickstart your spring boot and cache journey

Note: In testing
1. Run the application by using any idea of your choice (example VSCode)
2. By using postman or any other testing application you can check the validity of the application. Paste the following info accordingly
   Endpoint :
     - POST http://localhost:8080/product/save -> JSON data is 
     {
       "id": 1,
       "name": "Pencil",
       "amt": 3,
     }
     - GET http://localhost:8080/product/getById/{id}
     - PUT http://localhost:9999/product/delete/{id}
3. Sample Response
   - Product object for saving
   - Others are with status code
