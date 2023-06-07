# MIS IMÁGENES FAVORITAS (Prueba técnica)

<a href="http://yquetecuentas.com/f5/prueba-tecnica/index.jpg" target="_blank"><img src="http://yquetecuentas.com/f5/prueba-tecnica/index.jpg" alt="Index" width="200"></a>
<a href="http://yquetecuentas.com/f5/prueba-tecnica/gallery.jpg" target="_blank"><img src="http://yquetecuentas.com/f5/prueba-tecnica/gallery.jpg" alt="Galería" width="200"></a>
<a href="http://yquetecuentas.com/f5/prueba-tecnica/login.jpg" target="_blank"><img src="http://yquetecuentas.com/f5/prueba-tecnica/login.jpg" alt="Prototipo" width="200"></a>   

## Tabla de Contenido
1. [Información General](#Info-General)
2. [Desarrollo](#Desarrollo)
3. [Tecnologías](#Tecnologías)
4. [Instalación](#Instalación)
5. [Autoría](#Autoria)

## Información General
Prueba técnica para Factoría F5.
Desarrollo de una aplicación web para gestionar "mis imágenes favoritas".
Debe incluir:
- Listado de todas las imágenes (imagen + título)
- Gestión de las mismas:
    - Añadir una nueva imagen
    - Modificar una imagen ya existente
    - Eliminar una imagen.

### Inicio:
- Menú de navegación:
    - Inicio
    - Galería
    - Login
        - Logout
        - Admin galería
        - Añadir imagen
- Carrusel de imágenes
- Footer (reproduce la funcionalidad del menú superior) 
 
### Galería:
- Menú de navegación:
    - Inicio
    - Galería
    - Login
        - Logout
        - Admin galería
        - Añadir imagen
- Listado de imágenes
    - Imagen
    - Título
    - Botón de ampliar
    - Imagen ampliada
    - Botón de cierre de ampliación
- Footer (reproduce la funcionalidad del menú superior) 
 
### Login:
- Menú de navegación:
    - Inicio
    - Galería
    - Login
        - Logout
        - Admin galería
        - Añadir imagen
- Formulario de acceso
- Footer (reproduce la funcionalidad del menú superior) 

### Añadir elemento a la galería:
- Menú de navegación:
    - Inicio
    - Galería
    - Login
        - Logout
        - Admin galería
        - Añadir imagen
- Formulario para incluir nuevo elemento
- Footer (reproduce la funcionalidad del menú superior) 

### Añadir imagen al nuevo elemento:
- Menú de navegación:
    - Inicio
    - Galería
    - Login
        - Logout
        - Admin galería
        - Añadir imagen
- Formulario para añadir/modificar imagen al nuevo elemento
- Footer (reproduce la funcionalidad del menú superior) 

### Admin galería:
- Menú de navegación:
    - Inicio
    - Galería
    - Login
        - Logout
        - Admin galería
        - Añadir imagen
- Listado de todos los elementos de la galería
    - Imagen
    - Título
    - Botón de ampliar
        - Imagen ampliada
        - Botón de cierre de ampliación
    - Botón de eliminar elemento
    - Botón de modificar elemento
    - Botón de imagen
- Footer (reproduce la funcionalidad del menú superior) 

## Desarrollo
### Frontend
Utilizando Figma, desarrollamos una prototipo que nos sirviera de referencia para poder componer nuestra aplicación web, tanto la parte estrutural (HTML), como viual (SCSS). Optamos por un diseño com imágenes amplias, que cubran prácticamente toda la pantalla del dispositio, utilizando Bootstrap para, entre otras cosas, agilizar la creación del carrusel de imágenes.
Usamos VUE para añadir las funcionalidades necesarias: conexión a la API que nos proporcionará la gestión de las imágenes, aplicación de una sola página, gestión de vistas, stores para el almacenamiento de datos compartidos dentro de las vistas de la web, actualización en tiempo de ejecución de los contenidos, gestión de usuarios registrados (mostrar/ocultar contenido, limitación de navegación según roles, etc)... 

### Backend
Usando Java y su framework Spring Boot (junto a varias de sus dependencias), desarrollamos una aplicación que nos proporciona la API para gestionar las imágenes de nuestra aplicación web.
Utilizamos para ello la arquitectura de patrón MVC (modelo, vista, controlador), con la que gestionamos, de forma independiente, lo que es la lógica de la aplicación y la interfaz de cliente.
A través de la API, además de la gestión de las imágenes, gestionamos la autenticación y autentificación del usuario.

## Tecnologías
### Frontend
- HTML
- SCSS
- Bootstrap
- JavaScript
- VUE 3
    - Vitest
    - Pinia
    - Router

### Backend
- Java
- Spring Boot
    - Spring Boot DevTools
    - Spring Web
    - Spring Security
    - MySQL Driver
    - Spring Data JPA

### Otros
- Visual Studio Code
- Figma
- Git - GitHub

## Instalación

### Frontend
Desde la carpeta frontend
- npm install

### Backend
Precisa:
- Servidor con soporte para Java (Tomcat)
- Servidor MySQL

## Autoria
- [Johnny Ramirez] (https://github.com/JohnnyRamirezSancho)

