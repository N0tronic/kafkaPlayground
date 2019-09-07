#### Allgemein

Zugangsdaten Portainer: admin | kafka

#### Docker Compose

##### Run Application

`docker-compose up -d`

##### Scaling

`docker-compose scale servicename=3`

##### Shutdown

`docker-compose stop`

#### REST

Producer 1: http://localhost:8080/swagger-ui.html

Producer 2: http://localhost:8081/swagger-ui.html

Producer 3: http://localhost:8082/swagger-ui.html

#### Console producer and consumer

kafka-console-producer --broker-list localhost:9092 --topic personen

kafka-console-consumer --bootstrap-server localhost:9092 --topic personen --group console-consumers
