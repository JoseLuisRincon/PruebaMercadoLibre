<h2>Prueba Mercado Libre</h2>

El siguiente repositorio contiene el código de la prueba llamada "Cupón" correspondiente del proceso de entrevista de Mercado Libre.

<hr>

<h3>Instrucciones para ejecutar el código o la API</h3>

**Arquitectura de la solución**

Para la construcción de la solución se hizo uso de Spring Eureka, el cual permite registrar, descubrir y escalar más instancias de un microservicio, esto debido a que en la prueba mencionada se requiere que la API pueda soportar tráfico de hasta 100K rpm.
Igualmente se hizo de Spring Gateway, el cual permite enrutar por un único camino el acceso a todos los microservicios. Finalmente, para comunicarse con los servicios de Mercado Libre se hizo uso de Spring Cloud OpenFeign, el cual permite invocar servicios web. A continuación se adjunta un diagrama de despliegue que muestra de forma resumida la arquitectura mencionada:

![image](https://github.com/user-attachments/assets/968dac2d-e8e5-42a6-aa05-6d23d8ed0232)

**Ejecución de la solución**

Para ejecutar y probar la API es necesario iniciar los servicios en el siguiente orden:

<ol>
  <li>Eureka Server</li>
  <li>Microservicio de Mercado Libre</li>
  <li>API Gateway</li>
</ol>

Seguido de esto y por medio del endpoint /api/items/coupon se debe enviar el siguiente body:

```json
{
    "items_ids": [
        "MCO1470852325",
        "MCO1592105778",
        "MCO1402796433",
        "MCO2742004666",
        "MCO1356137231"
    ],
    "amount": 200000
}
```

Si el monto es suficiente para comprar mímimamente un ítem el servicio responde con el body y status HTTP 200-OK, de lo contrario devuelve el status 404-NOT_FOUND. A continuación se adjunta el response que devuelve el servicio cuando se le envia el body ya mostrado:

```json
{
    "items_ids": [
        "MCO2742004666",
        "MCO1592105778"
    ],
    "total": 130947.0
}
```

**Despliegue de la solución**

Para desplegar la solución se hizo uso de Google App Engine, para depslegar los microservicios se siguieron los siguientes pasos:

<ol>
  <li>Crear un proyecto en Google App Engine</li>
  <li>
    Agregar la dependencia en el proyecto de Google App Engine
    <br>
    <dependency>
        <groupId>com.google.cloud.tools</groupId>
	<artifactId>appengine-maven-plugin</artifactId>
	<version>2.8.1</version>
    </dependency>
  </li>
  <li>Descargar el SDK de Google Cloud Engine</li> 
  <li>
    Configurar proyecto con el siguiente yaml:
    <br>
	```yaml
runtime: java
env: flex
runtime_config:
  operating_system: "ubuntu22"
  runtime_version: "21"
handlers:
- url: /.*
  script: this field is required, but ignored
```  
  </li>
</ol>

<hr>

<h3>URL de la API</h3>

**Nota:** se intentó realizar el despliegue en Google App Engine pero no funciona correctamente la API

**URL:** https://arboreal-totem-442518-f4.uc.r.appspot.com:8090/api/items/coupon
