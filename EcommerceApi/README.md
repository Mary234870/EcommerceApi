Ecommerce API

 Project Overview

This is a RESTful Ecommerce API built using Spring Boot.
It provides basic CRUD operations for managing products.

Each product contains:

 id
 name
 description
 price
 category
 stockQuantity
 imageUrl

 This project uses **in-memory storage (ArrayList)**, so all data is lost when the application restarts.



 Setup Instructions

 Prerequisites

Make sure you have:

 Java 17+
 Maven
 VS Code or any Java IDE



2.Run the Application

 Using Maven:

bash
.\mvn spring-boot:run

Using VS Code:

 Open the project
 Run `EcommerceApiApplication.java`


 3. Base URL


http://localhost:8080/api/products




 API Endpoint Reference


 GET All Products

 **Method:** GET
 **Path:** `/api/products`
**Description:** Retrieve all products
***Response:** 200 OK

json
[]




 GET Product by ID

 **Method:** GET
 **Path:** `/api/products/{id}`
 **Description:** Retrieve a product by ID

Success (200 OK)

json
{
  "id": 1,
  "name": "Phone",
  "description": "Smartphone",
  "price": 10000,
  "category": "Electronics",
  "stockQuantity": 10,
  "imageUrl": ""
}


 Not Found (404)

No response body



CREATE Product

 **Method:** POST
 **Path:** `/api/products`
 **Description:** Create a new product

Request Body:

json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "category": "Electronics",
  "stockQuantity": 5,
  "imageUrl": ""
}


 Response (201 Created)

json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "category": "Electronics",
  "stockQuantity": 5,
  "imageUrl": ""
}




 UPDATE Product

 **Method:** PUT
 **Path:** `/api/products/{id}`
 **Description:** Update an existing product

 Request Body:

json
{
  "name": "Updated Laptop",
  "description": "High-end Gaming Laptop",
  "price": 60000,
  "category": "Electronics",
  "stockQuantity": 3,
  "imageUrl": ""
}


 Success (200 OK)

json
{
  "id": 1,
  "name": "Updated Laptop",
  "description": "High-end Gaming Laptop",
  "price": 60000,
  "category": "Electronics",
  "stockQuantity": 3,
  "imageUrl": ""
}


 Not Found (404)

No response body



 DELETE Product

 **Method:** DELETE
 **Path:** `/api/products/{id}`
 **Description:** Delete a product

Success (204 No Content)

No response body

 Not Found (404)

No response body



 Sample Request & Response

 Example: Create Product

**Request**


POST /api/products
Content-Type: application/json

json
{
  "name": "Tablet",
  "description": "Android Tablet",
  "price": 15000,
  "category": "Electronics",
  "stockQuantity": 7,
  "imageUrl": ""
}

**Response**

json
{
  "id": 2,
  "name": "Tablet",
  "description": "Android Tablet",
  "price": 15000,
  "category": "Electronics",
  "stockQuantity": 7,
  "imageUrl": ""
}




 Known Limitations

 Uses **in-memory storage (ArrayList)**
 Data resets when the application restarts
 No database integration
 No authentication/security
 No validation (accepts any input)


 Future Improvements

Integrate database (MySQL / PostgreSQL)
 Add validation (`@Valid`)
 Implement authentication (JWT)
 Add pagination and filtering endpoints
 Connect controller to `ProductService` properly



 
