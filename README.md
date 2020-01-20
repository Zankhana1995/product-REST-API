# product-REST-API
Spring Boot REST application 

This project is build in Spring boot 2 + H2 database + Rest API + Junit and Mockito

Steps :

mvn clean install

Go to the target folder

java -jar Spring-Boot-REST-API-Product-0.0.1-SNAPSHOT.jar

Swagger URL : http://localhost:8080/swagger-ui.html#

Verify your RESTful call. URL :

1) Create Product 

URL : http://localhost:8080/v1/products/createProduct

Request body (JSON) :

{
  "name": "Red Shirt",
  "description": "Red hugo boss shirt",
  "brand": "Hugo Boss",
  "tags": [
    "red",
    "shirt",
    "slim fit"
  ],
  "category": "apparel"
}

Response body :

{
  "id": "b112b470-fb45-43dc-8010-a788df33018b",
  "name": "Red Shirt",
  "description": "Red hugo boss shirt",
  "brand": "Hugo Boss",
  "tags": [
    "red",
    "shirt",
    "slim fit"
  ],
  "category": "apparel",
  "created_at": "2020-01-20T03:32:26.063"
}

2) Search Product by Category and createdAt from newest to oldest.

URL : http://localhost:8080/v1/products/searchProduct/findByCategory?category=apparel&pageNo=0&pageSize=10&sortBy=createdAt

Response body :

[
  {
    "id": "66e08af0-195b-4d20-b504-7f22d162e249",
    "name": "Green Shirt",
    "description": "Green hugo boss shirt",
    "brand": "Hugo Boss",
    "tags": [
      "red",
      "shirt",
      "slim fit"
    ],
    "category": "apparel",
    "created_at": "2020-01-20T03:33:33.255"
  },
  {
    "id": "d32c8b15-cf7b-4d06-9914-c35586b19e22",
    "name": "Blue Shirt",
    "description": "Blue hugo boss shirt",
    "brand": "Hugo Boss",
    "tags": [
      "red",
      "shirt",
      "slim fit"
    ],
    "category": "apparel",
    "created_at": "2020-01-20T03:33:21.46"
  },
  {
    "id": "b112b470-fb45-43dc-8010-a788df33018b",
    "name": "Red Shirt",
    "description": "Red hugo boss shirt",
    "brand": "Hugo Boss",
    "tags": [
      "red",
      "shirt",
      "slim fit"
    ],
    "category": "apparel",
    "created_at": "2020-01-20T03:32:26.063"
  }
]
