# product-REST-API
Spring Boot REST application 

This project is build in Spring boot 2 + H2 database + Rest API + Junit and Mockito

Steps:

1) mvn clean install

Go to the target folder

2) java -jar Spring-Boot-REST-API-Product-0.0.1-SNAPSHOT.jar

Swagger URL: http://localhost:8080/swagger-ui.html#

Verify RESTful call

1) Create Product 

URL: http://localhost:8080/v1/products/createProduct

Request body (JSON):

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

Response body:

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

URL: http://localhost:8080/v1/products/searchProduct/findByCategory?category=apparel&pageNo=0&pageSize=10&sortBy=createdAt

Response body:

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

3) Validation while creating the product 

URL: http://localhost:8080/v1/products/createProduct

Request body (JSON):

{
  "brand": "efefefefefefefefefefefefefefefefefefefefefe",
  "category": "efefefefefefefefefefefefefefefefefefefefefe",
  "description": "efefefefefefefefefefefefefefefefefefefefefe",
  "name": "efefefefefefefefefefefefefefefefefefefefefe",
  "tags": [
    "string"
  ]
}

Response body:

{
  "timestamp": "2020-01-20T08:43:36.338+0000",
  "status": "400 BAD_REQUEST",
  "message": "Validation Failed",
  "details": "uri=/v1/products/createProduct",
  "errors": [
    "Product category should not more than 30 characters",
    "Product brand should not more than 30 characters",
    "Product name should not more than 30 characters"
  ]
}

4) Validation while searching the Products

URL: http://localhost:8080/v1/products/searchProduct/findByCategory?category=abc&pageNo=0&pageSize=10&sortBy=createdAt

Response body:

{
  "timestamp": "2020-01-20T08:42:31.387+0000",
  "status": "404 NOT_FOUND",
  "message": "Products not found",
  "details": "uri=/v1/products/searchProduct/findByCategory",
  "errors": []
}

