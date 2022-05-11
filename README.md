# LogInterceptor

Problem Statement - For api requestes which  are received from external source, we have to log the request and headers and also log time taken to execute                       the request.
Notes - for get method as we know there will be no request body we just have to log headers

start Application - reload maven dependencies
                  - build the application
                  - run the application
                  
 Test the application - shared some sample curls below.please retrieve the curls from editor mode as preview mode adds tab spaces in curls. can be run from terminal or importing in postman.
 
///////////////////////////////////////////////////////////////////////////////////////////////////// \
curl 1 - post - request from internal service \
=====================================\
curl --location --request POST 'http://localhost:3030/printHeaders' \
--header 'Content-Type: application/json' \
--header 'User-Agent: Chrome' \
--header 'Referer: http.oyo.com' \
--data-raw '{
    "states": {
        "Andhrapradesh": "hyderabad",
        "Bihar": "patna",
        "delhi": "new delhi",
        "Assam": "Dispur"
    },
    "rankings": {
       "Andhrapradesh": 2,
        "Bihar": 3,
        "delhi": 1,
        "Assam": 4
    },
    "user_mode": "admin"
}'
////////////////////////////////////////////////////////////////////////////////////////////////////////////////\
curl 2 - post - request from internal service \
======================================================= \
curl --location --request POST 'http://localhost:3030/printHeaders' \
--header 'access-token: WXFubXJkYjljZH\' \
--header 'Content-Type: application/json' \
--header 'User-Agent: Chrome' \
--data-raw '{
    "states": {
        "Andhrapradesh": "hyderabad",
        "Bihar": "patna",
        "delhi": "new delhi",
        "Assam": "Dispur"
    },
    "rankings": {
       "Andhrapradesh": 2,
        "Bihar": 3,
        "delhi": 1,
        "Assam": 4
    },
    "user_mode": "admin"
}'
=======================================================\
curl 3- GET - request from external source \
======================================================= \
curl --location --request GET 'http://localhost:3030/printHeaders/1' \
--header 'access-token: WXFubXJkYjljZHcyV3pCb04xZHk6dEFzNFBmd3g1dHJVZFZ6VFEtLXo=' \
--header 'Content-Type: application/json' \
--header 'User-Agent: Chrome' \
--header 'Referer: http.oyo.com' \
--data-raw ''
=====================================================\
curl 4 - GET - request from nonexternal \
===================================================== \
curl --location --request GET 'http://localhost:3030/printHeaders/1' \
--header 'access-token: WXFubXJkYjljZHcyV3pCb04xZHk6dEFzNFBmd3g1dHJVZFZ6VFEtLXo=' \
--header 'Content-Type: application/json' \
--header 'User-Agent: Chrome' \
--data-raw ''
===================================================== \
curl 5 - PUT - request from external \
===================================================== \
curl --location --request PUT 'http://localhost:3030/printHeaders/1' \
--header 'access-token: WXFubXJkYjljZHcyV3pCb04xZHk6dEFzNFBmd3g1dHJVZFZ6VFEtLXo=' \
--header 'Content-Type: application/json' \
--header 'Referer: www.google.com' \
--data-raw '{
    "cancellation_page": false,
    "payment_page": true,
    "user_mode": "Consumer_Guest"
}'
===================================================== \
curl 6 - Put request from  non external \
===================================================== \
curl --location --request PUT 'http://localhost:3030/printHeaders/1' \
--header 'access-token: WXFubXJkYjljZHcyV3pCb04xZHk6dEFzNFBmd3g1dHJVZFZ6VFEtLXo=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "cancellation_page": false,
    "payment_page": true,
    "user_mode": "Consumer_Guest"
}'
====================================================== \
curl 7 - patch request from external \
====================================================== \
curl --location --request PATCH 'http://localhost:3030/printHeaders/1' \
--header 'access-token: WXFubXJkYjljZHcyV3pCb04xZHk6dEFzNFBmd3g1dHJVZFZ6VFEtLXo=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "states": {
        "Andhrapradesh": "hyderabad",
        "Bihar": "patna",
        "delhi": "new delhi",
        "Assam": "Dispur"
    },
    "rankings": {
       "Andhrapradesh": 2,
        "Bihar": 3,
        "delhi": 1,
        "Assam": 4
    },
    "user_mode": "admin"
}'
==================================================== \
curl 8 -patch request from external \
===================================================== \
curl --location --request PATCH 'http://localhost:3030/printHeaders/1' \
--header 'access-token: WXFubXJkYjl6dEFzd3g1dHJVZFZ6VFEtLXo=' \
--header 'Content-Type: application/json' \
--header 'Referer: http.facebook.com' \
--data-raw '{
    "states": {
        "Andhrapradesh": "hyderabad",
        "Bihar": "patna",
        "delhi": "new delhi",
        "Assam": "Dispur"
    },
    "rankings": {
       "Andhrapradesh": 2,
        "Bihar": 3,
        "delhi": 1,
        "Assam": 4
    },
    "user_mode": "admin"
}'
