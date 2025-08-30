# OO Design - Generics, Media y Desviación Estándar

## Descripción del proyecto
Este proyecto corresponde a un laboratorio en el cual se implementa:

- Una **lista enlazada genérica propia** (`MyLinkedList<E>`) que es **compatible con la API de colecciones de Java** al extender `AbstractList<E>`.
- Lectura de números reales desde un archivo de texto.
- Cálculo de **media** y **desviación estándar muestral** de un conjunto de datos.
- Verificación de resultados usando los valores esperados de la Tabla 2 del enunciado.

El programa se probó con dos columnas de datos y los resultados coinciden con los valores esperados:

| Columna | Media esperada | Desv. Est. esperada |
|---------|----------------|----------------------|
| 1       | 550.6          | 572.03               |
| 2       | 60.32          | 62.26                |

---

## Estructura del proyecto

```plaintext
src/
 └── main/java/escuelaing/edu/co/ARSW
     ├── App.java
     ├── FileNumberReader.java
     ├── MyLinkedList.java
     └── StatsCalculator.java

 └── main/java/escuelaing/edu/co/ARSW
     └── StatsCalculatorTest.java

 └── test/resources/
     ├── column1.txt
     └── column2.txt

pom.xml
README.md
```


---

## Clases principales

- **`MyLinkedList<E>`**  
  Implementación propia de una **lista enlazada doblemente** que extiende `AbstractList<E>`.  
  Soporta operaciones básicas (`add`, `get`, `remove`, `set`, `size`, `clear`).  

- **`FileNumberReader`**  
  Utilidad para leer números `double` desde un archivo de texto (separados por espacios o comas).  
  Devuelve un `MyLinkedList<Double>`.

- **`StatsCalculator`**  
  Contiene métodos estáticos para calcular:
  - Media aritmética
  - Desviación estándar muestral (usando \(n-1\) en el denominador)

- **`App`**  
  Clase principal (`main`).  
  Recibe como argumento la ruta de un archivo de números y muestra en consola el tamaño del dataset, la media y la desviación estándar.

- **`StatsCalculatorTest`** (JUnit 5)  
  Pruebas unitarias que validan los resultados con los datos de ejemplo (`column1.txt` y `column2.txt`).

---

## ⚙️ Compilación y ejecución

### 1. Compilar el proyecto
mvn clean compile

### 2. Ejecutar las pruebas
mvn test

### 3. Ejecutar el programa
    * mvn exec:java "-Dexec.args=src/test/resources/column1.txt"

    * mvn exec:java "-Dexec.args=src/test/resources/column2.txt"

## Requisitos
    * Java 17
    * Maven 3.8+

## Autor
    Juan David Rodriguez Rodriguez
