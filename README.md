# Singleton para Configuración de Aplicación

Este proyecto implementa el patrón de diseño **Singleton** en Java para gestionar configuraciones de una aplicación. Utiliza un archivo de propiedades (`config.properties`) para almacenar configuraciones clave y una clase Singleton para leer y gestionar estas configuraciones.

## Estructura del Proyecto

```
Singleton-para-Configuraci-n-de-Aplicaci-n-main/
|-- pom.xml
|-- src/
|   |-- main/java/singleton/Localconfiguracion.java
|   |-- main/java/singleton/TestConfiguracion.java
|   |-- main/resources/config.properties
|-- target/
    |-- classes/singleton/Localconfiguracion.class
    |-- classes/singleton/TestConfiguracion.class
    |-- classes/config.properties
```

### 1. `pom.xml`

Es el archivo de configuración de Maven, que maneja las dependencias y la construcción del proyecto.

### 2. `Localconfiguracion.java`

Implementa el patrón Singleton para gestionar la configuración de la aplicación. Carga las propiedades desde `config.properties` y proporciona métodos para acceder a los valores de configuración.

#### Código clave:

```java
public class Localconfiguracion {
    private static Localconfiguracion instancia;
    private Properties propiedades;

    private Localconfiguracion() {
        propiedades = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                propiedades.load(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Localconfiguracion getInstancia() {
        if (instancia == null) {
            instancia = new Localconfiguracion();
        }
        return instancia;
    }

    public String getPropiedad(String clave) {
        return propiedades.getProperty(clave);
    }
}
```

### 3. `TestConfiguracion.java`

Clase de prueba que demuestra el uso de `Localconfiguracion`.

#### Ejemplo de uso:

```java
public class TestConfiguracion {
    public static void main(String[] args) {
        Localconfiguracion config = Localconfiguracion.getInstancia();
        System.out.println("Valor de clave: " + config.getPropiedad("clave"));
    }
}
```

### 4. `config.properties`

Archivo de propiedades que contiene configuraciones clave-valor.

Ejemplo:

```
appName=MiAplicacion
version=1.0.0
modo=produccion
timeout=30
```

## Ejecución del Proyecto

1. Asegúrate de tener Java y Maven instalados.
2. Ejecuta el siguiente comando para compilar el proyecto:
   ```sh
   mvn clean install
   ```
3. Corre la clase de prueba:
   ```sh
   java -cp target/classes singleton.TestConfiguracion
   ```

Esto imprimirá en consola los valores de configuración definidos en `config.properties`.

## Desarrollador = Stivenco12

