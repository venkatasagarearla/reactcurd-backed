# React CRUD App with Spring Boot, MySQL, Docker, Prometheus & Grafana.
- **Containerization**: Docker & Docker Compose
- **Monitoring**: Prometheus & Grafana



added docker compose.yml and prometheus.yml.currently app and MySQL both are running are inside the Docker .Data is not storing inside the local MySQL workbeanch
Right now,  Docker Compose is starting a new MySQL container, with a new empty database — that's why app is inserting data into it, and not into the  in Workbench.
to store in local MySQL workbench just remove the MySQL service from docker-compose.yml and change the datasource connection to spring.datasource.url=jdbc:mysql://host.docker.internal:3306/existing_db
advantages of running MySQL in docker
 -MySQL version, config, and data are containerized and consistent across all environments (local, staging, production).
 -No “it works on my machine” problem.

