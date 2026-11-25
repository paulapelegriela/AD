# Gestor de reservas de aulas

## ¿De qué trata este proyecto?

Este proyecto consiste en desarrollar una aplicación de consola en Java para gestionar las reservas de aulas de MEDAC Fuenlabrada.

La aplicación permite registrar nuevas reservas indicando el nombre del alumno, el aula y la fecha. También permite consultar todas las reservas, buscar las de un aula concreta y eliminar una reserva introduciendo su identificador.

Toda la información se guarda en una base de datos PostgreSQL, a la que nos conectamos desde Java utilizando JDBC.

## Tecnologías utilizadas

- Java: para desarrollar la aplicación.
- Maven: para gestionar el proyecto y sus dependencias.
- JDBC: para conectar Java con la base de datos.
- PostgreSQL: para almacenar las reservas.
- Docker y Docker Compose: para ejecutar PostgreSQL mediante un contenedor.
- NetBeans: entorno utilizado para desarrollar el proyecto.

## Funcionamiento de la aplicación

Al iniciar el programa aparece un menú con cinco opciones:

1. **Registrar una reserva:** permite introducir el nombre del alumno, el aula y la fecha.
2. **Mostrar todas las reservas:** muestra todas las reservas que hay guardadas en la base de datos.
3. **Buscar reservas por aula:** permite consultar las reservas de un aula determinada.
4. **Eliminar una reserva:** elimina una reserva indicando su ID.
5. **Salir:** cierra la aplicación.

El identificador de cada reserva se genera automáticamente desde PostgreSQL.

## Base de datos

La aplicación utiliza una base de datos llamada `reservas`, que contiene una tabla llamada `reserva`.

La tabla tiene los siguientes campos:

| Campo | Tipo | Descripción |
|---|---|---|
| id | BIGINT | Identificador de la reserva |
| alumno | VARCHAR(100) | Nombre del alumno |
| aula | VARCHAR(20) | Aula reservada |
| fecha | DATE | Fecha de la reserva |

## Cómo ejecutar el proyecto

Para poder ejecutar la aplicación es necesario tener instalado Java, NetBeans y Docker Desktop.

**1. Configurar la variable de entorno en Windows**

Para que Java pueda conectarse a PostgreSQL sin tener que escribir la contraseña directamente en el código, he creado una variable de entorno en Windows llamada `POSTGRES_PASSWORD`.

Esta variable contiene la misma contraseña que se utiliza en el archivo `docker-compose.yml`.

Para crearla desde PowerShell se puede utilizar el siguiente comando:

```powershell
setx POSTGRES_PASSWORD "tu_contraseña"
```

Una vez creada, es necesario cerrar y volver a abrir NetBeans para que reconozca la nueva variable de entorno.

En Java se obtiene su valor mediante:

```java
System.getenv("POSTGRES_PASSWORD");
```

De esta manera, la aplicación puede utilizar la contraseña para establecer la conexión con PostgreSQL sin tenerla escrita directamente en el código fuente.

**2. Iniciar la base de datos**

Desde la terminal, dentro de la carpeta del proyecto, ejecutamos:

```bash
docker compose up -d
```

Para comprobar que PostgreSQL está funcionando:

```bash
docker compose ps
```

**3. Ejecutar la aplicación**

Abrimos el proyecto en NetBeans y ejecutamos la clase `Main.java`.

Una vez iniciado, aparecerá el menú desde el que podremos gestionar las reservas.

## Persistencia de los datos

Para conservar las reservas se ha configurado un volumen en Docker Compose.

De esta forma, los datos no se pierden al detener y volver a crear el contenedor.

Para detener los contenedores:

```bash
docker compose down
```

Para volver a iniciarlos:

```bash
docker compose up -d
```

Después de reiniciar PostgreSQL, las reservas anteriores seguirán estando disponibles.

**Importante:** no utilizar `docker compose down -v`, ya que eliminaría también el volumen donde se guardan los datos.

---

## Autor

Actividad práctica realizada para la asignatura de Acceso a Datos, hecha por Paula Pelegri Ela.