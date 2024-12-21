# Grocery Booking API

## Description
This project implements a **Grocery Booking API** that allows **users** to view grocery items and place orders, while allowing **admins** to manage the grocery inventory. The system supports the following features:

- **Admin** can:
  - Add, update, and delete grocery items.
  - Manage inventory levels of grocery items.

- **User** can:
  - View available grocery items.
  - Place orders for multiple grocery items.

## Features
- **Admin**:
  - Manage grocery items.
  - View and modify inventory.

- **User**:
  - View available items.
  - Book multiple items in a single order.

## Technologies Used
- **Spring Boot**: Backend framework.
- **H2 Database**: In-memory relational database for quick setup and development.
- **REST API**: To expose endpoints for interacting with the application.

## Installation
To run the project locally:
1. Clone the repository:
   ```bash
   git clone <repository_url>

2. Navigate to the project directory:

cd grocery-booking-api

3. Run the application:

mvn spring-boot:run


The API will start on port 8080 by default.
API Endpoints
Admin Endpoints

    POST /admin/groceries: Add a new grocery item.
        Request body: {"name": "Apple", "price": 2.99, "inventory": 100}

    GET /admin/groceries: View all grocery items.

    PUT /admin/groceries/{id}: Update a grocery item.
        Request body: {"name": "Apple", "price": 3.49, "inventory": 150}

    DELETE /admin/groceries/{id}: Delete a grocery item.

User Endpoints

    GET /user/groceries: View all available grocery items.

    POST /user/orders: Place an order with multiple items.
        Request body: {"groceryItems": [{"id": 1, "quantity": 2}, {"id": 2, "quantity": 1}]}
