## Scratch_Bling
A Simple API to provide access to the Bling Scratcher inventory.

## Getting started 
# Run locally 
1. open a new terminal window
2. cd into project folder
3. type "maven spring-boot:run" (MacOS)
4. open Postman to make API calls on "http://localhost:8080"

## Usage
1. GET 
    * (all available scratchers) localhost:8080/api/scratchers
        - returns all available scratchers 
    * (find a scrather by its ID) localhost:8080/api/scratch{id}
        -e.x localhost:8080/api/scratch2
2. POST
    * (adds a new scratcher) localhost:8080/api/scratcher
        '''javascript 
            { 
                "name": "Test add new scratcher",
                "description": "Gold handle and fancy emeralds",
                "sizes": ["XL","L","M","S"],
                "price": 4343.00
            }
3. PUT 
    * (updates a scratcher by its id or creates a new one if not found) localhost:8080/api/scratcher{id}
        - e.x. localhost:8080/api/scratcher7
        '''json
            { 
                "name": "Glitz and Gold",
                "description": "Gold handle and fancy emeralds",
                "sizes": ["XL","L","M","S"],
                "price": 9999.0
            }
4. DELETE
    * (removes a scratcher from the database, returns custom exception if not found) localhost:8080/api/scratcher{id}
    - e.x. localhost:8080/api/scratcher7
 

## Built With

* IntellJ IDE - Development Environment (https://netbeans.org/)
* Java (v11) - language (https://java.com/en/download/)
* Spring Boot (v2.5.0) - Spring Framework (https://start.spring.io/)
* Maven - Build Automation (https://maven.apache.org/what-is-maven.html)
* 

## Versioning

Version 1.0, check the edits branch for New commits containg info on updates to the project.

## Authors

* **Luke MacLean** - *Initial work* - (https://github.com/lsmaclean0)
