# InventoryBackend
This project is a backend project which provide required APIs for inventory management system.

How to use it.

- Install and IDE like STS or Eclipse
- Import the project a maven.
- let it build and get all the dependencies.
- Now download and install mongoDB and check whether it is listening on 27017 port.
- update the project and run as spring boot app.
- Now test various below APIs

This has a simple database model:

Collections:
- Supplier (Can create new supplier, view all suppliers, and view supplier by Id)
  - emailId : primary key
  - firstName
  - lastName
  - location
  - phoneNumber
