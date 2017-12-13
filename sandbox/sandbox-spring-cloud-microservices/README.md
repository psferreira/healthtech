## Arquitetura de microserviços: criando microserviços usando Spring Cloud, Eureka e Zuul

# Arquitetura



A Framework Spring fornece um conjunto de bibliotecas para criar microserviços em Java. Eles são uma parte do projeto Spring Cloud. Microserviços usando o Spring Boot e as seguintes tecnologias:



**Zuul** –  serviço de gateway que fornece roteamento dinâmico, monitoramento, resiliência, segurança, ...

**Ribbon** – balanceador de carga (client side)

**Feign** – cliente declarativo REST

**Eureka** – registro e descoberta de serviços



A imagem representa a arquitetura implementada. O cliente chama o endpoint disponível dentro do serviço "customer" que armazena os dados básicos do cliente via Zuul gateway. Este endpoint interage com o serviço "account" para coletar informações sobre contas de clientes atendidas pelo endpoint do serviço "customer". Cada serviço se registra no serviço de descoberta Eureka automaticamente no arranque.



![alt text](arch.png "Arquitetura microserviços implementada")



# Testar



`` mvn spring-boot:run -f sandbox-spring-cloud-microservices/sandbox-spring-cloud-microservices-discovery-service/pom.xm ``


