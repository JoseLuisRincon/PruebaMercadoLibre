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

<h3>URL de la API</h3>

**Nota:** se intentó realizar el despliegue en Google App Engine pero no funciona correctamente la API

**URL:** https://arboreal-totem-442518-f4.uc.r.appspot.com:8090/api/items/coupon
