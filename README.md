# ddd-purchaser
This project is focus on microservices. It is a e-Commerce application, whose business model is to buy or sell your products. 

## Scala (AKKA HTTP)
The good part of AKKA HTTP is you can create multiple actors running on different port, which will be acting as a different server within an application. Using AKKA HTTP, the two services Order, Product can be distributed and clustered using AKKA HTTP

## Node (Express and Passport)
For registering and authenticating user, this service generates JWT token which can be used around different services for authorization and authentication.

## Python (Flask and ElasticSearch)
The service is used to generate fast search result using elasticsearch. The data is exposed using Flask API

## Kafka
The streaming platform for passing data between services
