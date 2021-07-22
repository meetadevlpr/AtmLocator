Application Developed with Spring Boot Application

UnZip The Application 

execute **mnvnw clean build**

Search The File Name **AtmLocatorDemoApplication** and Execute The Main Method.

Once Application Start On Port 8080

We Can see the swagger URL **http://localhost:8080/swagger-ui.html**

As, I have introduced Spring Security In the Application So need To Authorize Before execute any specific API

Can Find UserName and Password In **AtmLocatorDemoApplication** Class

There are two API EndPoint Has Configured 

`localhost:8080/api/atm/v1/findAll` -- Which Fetch All the ATM Location List
`localhost:8080/api/atm/v1/findByCity/{city}` -- Which fetch All the ATM Location by City.