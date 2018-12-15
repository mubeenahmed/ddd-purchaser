# ddd-purcahser

ddd-purchaser, this repository is about designing the application using Domain Driven Approach. Mainly, DDD is used for the large and complex projects. 

Apart from different terminology and rules, DDD follows. Following the concept of microservices and cockburn's architecture in mind, DDD helps to seperate different details such as database, streaming API and other infrastructure seperated from the core business. This helps to convert monolith application to microservices more easily. 

Seperating details helps to focus more on domain/business than in details, furthermore it also allows to change technologies for example changing database from MongoDB to MySQ without pain or updating any framework will be more easy and without breaking lot of stuff.


Notice, in the project, MongoDB is used in Product domain and RDMS database are used in Order. If at anytime, one needs to change MongoDB it will only effects the implementation of CategoryRepository class
