# Estágio 1: Construção (Build)
# Usa a imagem oficial do Maven para baixar as dependências e compilar o código
FROM maven:latest AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compila o projeto ignorando os testes (para o deploy ser mais rápido)
RUN mvn clean package -DskipTests

# Estágio 2: Execução (Run)
# Usa uma imagem mais leve do Java 26 
FROM eclipse-temurin:26-jdk
WORKDIR /app
# Copia apenas o arquivo .jar compilado do estágio 1
COPY --from=build /app/target/*.jar app.jar

# orta que o Spring Boot usa
EXPOSE 8080

# Comando para ligar o servidor
ENTRYPOINT ["java", "-jar", "app.jar"]