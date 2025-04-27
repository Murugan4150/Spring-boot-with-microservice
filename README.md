**🧩 Tech Stack**
Backend: Spring Boot, Spring Cloud (OpenFeign)


**Database:** MySQL / MongoDB


**Security:** Spring Security + JWT (optional for User Service)


**Utils:** Lombok, MapStruct (optional)



**📦 Modules & Responsibilities**
🔹 1. User Service (Master Module)
Manage Users (Admin, Staff)


Roles & Authentication (optional)


FeignClient for user info


**Endpoints:**
POST /users – Create user


GET /users/{id} – Get by ID


GET /users/email/{email} – Get by email



**🔹 2. Product Service (Master Module)**
Manage Products (Add/Update/Delete)


List by category/type


FeignClient for product info


**Endpoints:**
POST /products – Add product


GET /products/{id} – Get by ID


GET /products – List all



**🔹 3. Inventory Service (Stock Module)**
Track & Update Stock


Low-stock alerts (optional)


Validate product via FeignClient


**Endpoints:**
POST /inventory – Add stock


PUT /inventory/{productId} – Update stock


GET /inventory/{productId} – Get stock



**🔹 4. Order Service (Order Module)**
Place & Manage Orders


Deduct stock post-order


Fetch orders by user/product


**Endpoints:**
POST /orders – Place order


GET /orders/{id} – Get by ID


GET /orders/user/{userId} – Orders by user


**Flow:**
Validate user & product (via FeignClient)


Check & deduct stock (Inventory)


Place order



🔄 FeignClient Communication
Order ➝ ProductService – Validate product


Order ➝ UserService – Validate user


Order ➝ InventoryService – Check & update stock
