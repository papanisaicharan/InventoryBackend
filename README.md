# InventoryBackend
This project is a backend project which provide required APIs for inventory management system.

How to use it.

- Install an IDE like STS or Eclipse.
- Import the project as maven.
- let it build and get all the dependencies.
- Now download and install mongoDB and check whether it is listening on 27017 port.
- update the project and run as spring boot app.
- Now test various APIs

This has a simple database model with below collections and fields:

Collections:
- Supplier (Can create new supplier, view all suppliers, and view supplier by Id): Suppliers supply the products.
  - emailId : primary key
  - firstName
  - lastName
  - location
  - phoneNumber
- Distributors: (Can create new Distributor, view all and view by distributor Id): Distibutor distributes the products to customers.
  - emailId : primary key
  - firstName
  - lastName
  - location
  - phoneNumber
- Products: (Can create new products, view them all and view by productId)
  - Product Id: primary key
  - Product Name
  - Product Description
  - Units
  - Quantity
  - Supplier Id (emailId in supplier collection)
  - Unit Price
- Orders: (Can create new orders, View orders, Edit orders, Delete orders)
  - orderId: primary key
  - product Name
  - productId (pulled from product collection)
  - totalPrice (calculated based on quantity and product unit price)
  - orderedOn 
  - quantity
  - distributorName
  - distributorId (pulled from distributor collection)
  - delivery address
