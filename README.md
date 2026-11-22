# Simulación de Control de Vencimientos y Multas en Biblioteca (Interfaces y Polimorfismo en Java)

Este proyecto es una aplicación en Java que modela un sistema de gestión de préstamos y devoluciones bibliotecarias, implementando una arquitectura basada en **interfaces (`interface`)** para desacoplar el control de vencimientos de los distintos tipos de materiales prestables (libros, revistas y tesis) con tarifas diferenciadas de multa por días de atraso. Pone en práctica conceptos fundamentales de la Programación Orientada a Objetos (POO) como la definición de contratos obligatorios mediante interfaces, la sobrescritura polimórfica de comportamiento (`@Override`), la inyección de dependencias por parámetros y el procesamiento centralizado en memoria sin persistencia en base de datos.

---

## Clases y Estructura del Sistema

El diseño del software se organiza a través de una interfaz de contrato, sus respectivas clases implementadoras por tipo de material, un componente controlador de vencimientos y un punto de ejecución:

* **`Prestable` (Interfaz)**: Define el contrato estándar que cualquier material sujeto a préstamo bibliotecario debe cumplir obligatoriamente.
* **Método abstracto**: `double calcularMultaDemora(int diasAtraso)`: Obliga a las clases implementadoras a definir su propia fórmula de cálculo de multa según la cantidad de días de atraso.


* **`LibroPrestamo`**: Implementa la interfaz `Prestable` para modelar el préstamo de libros con tarifa estándar de demora.
* **Sobrescritura (`@Override`)**:
* `calcularMultaDemora(int diasAtraso)`: Calcula el recargo multiplicando los días de atraso por `$100` (`diasAtraso * 100`).




* **`RevistaPrestamo`**: Implementa `Prestable` para modelar el préstamo de publicaciones periódicas o revistas con un recargo diario intermedio.
* **Sobrescritura (`@Override`)**:
* `calcularMultaDemora(int diasAtraso)`: Calcula la multa multiplicando los días de atraso por `$150` (`diasAtraso * 150`).




* **`TesisPrestamo`**: Implementa `Prestable` para modelar el préstamo de trabajos académicos o tesis con penalización diaria más elevada.
* **Sobrescritura (`@Override`)**:
* `calcularMultaDemora(int diasAtraso)`: Calcula el importe a abonar multiplicando los días de atraso por `$200` (`diasAtraso * 200`).




* **`ControlVencimientos`**: Componente controlador encargado de procesar la devolución de materiales y emitir el detalle de la multa.
* **Método operativo**: `procesarDevolucion(Prestable material, int dias)`: Recibe polimórficamente cualquier objeto que implemente `Prestable`, invoca dinámicamente `calcularMultaDemora(dias)` e imprime por consola la cantidad de días de atraso y el monto de la multa resultante.


* **`Main`**: Punto de entrada del programa. Instancia `ControlVencimientos` junto con los tres tipos de materiales (`LibroPrestamo`, `RevistaPrestamo` y `TesisPrestamo`) y ejecuta `procesarDevolucion(...)` con `3` días de atraso para cada uno, separando cada resultado por consola.

---

## Reglas de Negocio y Control de Validación

1. **Contrato Estricto de Multa:** Mediante la interfaz `Prestable`, cualquier nuevo material incorporable al sistema (por ejemplo, enciclopedias, mapas o material audiovisual) debe implementar obligatoriamente `calcularMultaDemora(int diasAtraso)`.
2. **Tarifas Diferenciadas por Material:** Cada clase implementadora encapsula su propio valor por día de retraso (`$100` para libros, `$150` para revistas y `$200` para tesis), evitando estructuras condicionales centralizadas en el controlador.
3. **Desacoplamiento mediante Polimorfismo:** `ControlVencimientos` depende únicamente de la abstracción `Prestable`, resolviendo en tiempo de ejecución la tarifa específica de cada material recibido.

---

## Salida por Consola

Al ejecutar la clase `Main`, el programa genera el siguiente resultado:

```text
Dias de atraso: 3
Multa a pagar: $300.0
----------------
Dias de atraso: 3
Multa a pagar: $450.0
----------------
Dias de atraso: 3
Multa a pagar: $600.0

```

---

## Conceptos de Programación Aplicados

* **Polimorfismo de Interfaces:** Uso de un contrato común (`interface`) para calcular multas heterogéneas a través de una misma referencia tipada.
* **Principio de Inversión de Dependencias:** El controlador de vencimientos (`ControlVencimientos`) trabaja sobre una abstracción en lugar de depender de clases concretas.
* **Separación de Responsabilidades:** División clara entre las reglas de penalización de cada material, el procesamiento de devoluciones en `ControlVencimientos` y la ejecución de pruebas en `Main`.
