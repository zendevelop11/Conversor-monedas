# Conversor de Monedas

## Descripción del Proyecto
Este proyecto es una aplicación de consola desarrollada en Java que permite convertir valores entre distintas monedas utilizando datos obtenidos a través de una API de tipo Exchange Rate. El objetivo es aplicar conceptos de programación orientada a objetos, manejo de JSON y consumo de APIs para resolver un problema real de conversión de monedas de manera precisa.

## Características
- **Interfaz interactiva de consola:** La aplicación presenta un menú intuitivo con opciones para realizar diferentes conversiones de monedas.
- **Consumo de una API de tasas de cambio:** La aplicación utiliza la API de Exchange Rate para obtener las tasas de conversión más actualizadas.
- **Conversión en tiempo real:** Los resultados se calculan y presentan de forma inmediata tras ingresar el valor deseado.
- **Loop continuo:** La aplicación permite realizar varias conversiones sin necesidad de reiniciarla.
- **Soporte para diferentes monedas:** Se incluyen varias opciones predefinidas de conversión, como dólares a pesos argentinos, reales brasileños a dólares, entre otros.

## Requisitos Previos
Para poder ejecutar este proyecto es necesario contar con lo siguiente:

- Conocimientos en Java y programación orientada a objetos.
- Entorno de desarrollo configurado para Java (JDK y un IDE como IntelliJ IDEA).
- Conexión a Internet para consumir los datos de la API.

## Configuración del Entorno
1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```
2. **Configurar el entorno Java:**
   - Asegúrate de tener instalado el JDK.
   - Configura las variables de entorno necesarias para Java.
3. **Obtener la API Key:**
   - Regístrate en el servicio de la API de Exchange Rate.
   - Genera tu API Key y reemplázala en el código fuente en el lugar indicado.

## Uso de la Aplicación
1. Al ejecutar la aplicación, se mostrará un menú con opciones de conversión.
2. Selecciona la opción deseada.
3. Ingresa el valor a convertir.
4. Recibe el resultado calculado en tiempo real.
5. Continúa realizando conversiones o elige la opción de salir.


## API Utilizada
El proyecto hace uso de la API de Exchange Rate, la cual permite obtener tasas de conversión de diversas monedas de forma gratuita hasta un límite de solicitudes.

**Documentación:** [Exchange Rate API](https://exchangerate-api.com)


