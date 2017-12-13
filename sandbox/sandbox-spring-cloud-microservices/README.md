## Microservices Architecture Sandbox: Creating microservice using Spring Cloud, Eureka and Zuul



# Arquitetura



Spring framework provides set of libraries for creating microservices in Java. They are a part of Spring Cloud project. Today I’m going to show you how to create simple microservices using Spring Boot and following technologies:



**Zuul** –  gateway service that provides dynamic routing, monitoring, resiliency, security, and more

**Ribbon** – client side load balancer

**Feign** – declarative REST client

**Eureka** – service registration and discovery



Here’s picture with application architecture. Client calls endpoint available inside customer-service which stores basic customer data via Zuul gateway. This endpoint interacts with account-service to collect information about customer accounts served by endpoint in account-service. Each service registering itself on Eureka discovery service.



![alt text](arch.png "Logo Title Text 1")




