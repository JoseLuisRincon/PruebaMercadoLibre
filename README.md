<h2>Prueba Mercado Libre</h2>

El siguiente repositorio contiene el código de la prueba llamada "Cupón" correspondiente del proceso de entrevista de Mercado Libre.

<hr>

<h3>Instrucciones para ejecutar el código o la API</h3>

**Arquitectura de la solución**

Para la construcción de la solución se hizo uso de Spring Eureka, el cual permite registrar, descubrir y escalar más instancias de un microservicio, esto debido a que en la prueba mencionada se requiere que la API pueda soportar tráfico de hasta 100K rpm.
Igualmente se hizo de Spring Gateway, el cual permite enrutar por un único camino el acceso a todos los microservicios. A continuación se adjunta un diagrama de despliegue que muestra de forma resumida la arquitectura mencionada:

![image](https://github.com/user-attachments/assets/8a890165-07cf-4c22-a80f-28466353880f)

**Ejecución de la solución**

Para ejecutar y probar la API es necesario iniciar los servicios en el siguiente orden:

<ol>
  <li>Eureka Server</li>
  <li>Microservicio de Mercado Libre</li>
  <li>API Gateway</li>
</ol>
