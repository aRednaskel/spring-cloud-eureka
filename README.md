# Spring-cloud-eureka

Spring-cloud-eureka is a project that uses a service registry ([Eureka Server](https://github.com/aRednaskel/spring-cloud-eureka/tree/master/service-discovery-server)), a two REST services which register itself at the registry (Eureka Client).

The two services are:
#### [Simplified bank application](https://github.com/aRednaskel/spring-cloud-eureka/tree/master/bankingApp) with CRUD operations
_Entities_
```
users
accounts
cards 
transfers
```

#### [Simplified auction application](https://github.com/aRednaskel/spring-cloud-eureka/tree/master/auctionApp) with CRUD operations
_Entities_
```
auctions
orders
```
Each application is able to retrieve necessary data from the other service.
