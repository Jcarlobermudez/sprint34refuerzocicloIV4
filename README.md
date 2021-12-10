# sprint34refuerzocicloIV4
Pasos
1. Crear el proyecto en la página de spring boot en el siguiente link: https://start.spring.io/
2. Configurar las caracteristicas del proyecto, seleccionar las opciones siguientes:
-Project=>Maven Project
-Language=>Java
-Spring Boot=>2.6.1
-Group: colocar el nombre de su proyecto si lo desea realizar.
-Packaging=>Jar
-Version Java=>11
3. Agregar las dependencias necesarias del proyecto, se buscaron y seleccionaron las siguientes:
-Spring Data MongoDB
-Spring Web
-Spring Boot DevTools
-Spring Web Services


Crear los packages controllers, models, repositories, services y los archivos de Java main y ServletInitializer

Crear las clases en el package de controllers
-AddressModel
-ClienteModel
-ProductModel

Crear las interfaces en el package de repository
-ClienteRepository

Crear las clases en el package de controllers
-ClienteController


ClienteModel
{
    "id": "one",
    "nombre": "Carlos",
    "apellido": "Mejía",
    "telefono": "310101011",
    "fRegistro": "2021-11-13",
    "puntos": 100,
}

{
"nombre":"pacho",
"apellido":"Pinzon",
"telefono":"2021-12-03",
"puntos":10,
"address":{"ciudad":"Monteria, "departamento":"Cordoba", "codigoPostal":"2020202"},
"productos":[{"nombre":"lavadora","cantidad":1,"price":250000},{"nombre":"plancha","cantidad":2,"price":90000}]
}

{
    "id": "1",
    "nombre": "Juan",
    "apellido": "Conzales",
    "telefono": "0180001010",
    "fRegistro": "2021-11-14"
}

{
    "nombre": "Ricardo",
    "apellido": "Pérez",
    "telefono": "0180002211",
    "fRegistro": "2021-11-20",
    "puntos": "100"
}

https://spring.getdocs.org/en-US/spring-data-docs/spring-data-mongodb/reference/mongo.repositories/mongodb.repositories.queries.html


echo "# refuerzociclo4IV" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Jcarlobermudez/refuerzociclo4IV.git
git push -u origin main

git remote add origin https://github.com/Jcarlobermudez/refuerzociclo4IV.git
git branch -M main
git push -u origin main
