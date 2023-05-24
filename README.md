# MutantRecruiting Java API
![magneto](https://static.wikia.nocookie.net/marvelvscapcomespaol/images/7/73/Magnintro.gif/revision/latest?cb=20170504234542&path-prefix=es)

## Introduccion
MutantRecruiting permite reconocer mutantes (basándose en su secuencia de ADN) y reclutar para la lucha contra los X-Men.

## Requerimientos
- Java  1.17.x
- Maven 3.x.x
- MySQL 5.x.x

## Resource
```
├─ src    
│  └── resource
│      └── db  
│          ├── human.sql                       // Archivo de import MySql
│      └── request  
│          ├── Mutant.postman_collection.json  // Archivo de import collection Postman
```

## Servicios
* `POST /mutant` Detecta si la secuencia de ADN enviada es un humano mutante y lo guarda.
   - 200 - OK
      ```
      ```
   - 403-Forbidden
      ```
       {
         "message": "DNA does not correspond to a mutant"
       }
      ``` 
   - 500-internal server
      ```
       {
         "message": "There are characters that do not represent the nitrogenous base of DNA"
       }
      ``` 
* `GET /stats`
   - 200-OK
      ```
       {
         "count_mutant_dna": 3,
         "count_human_dna": 14,
         "ratio": 0.2
       }
      ``` 
