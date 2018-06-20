FROM drhetnet/ubuntu1604java8:v1

MAINTAINER Valterfi, https://github.com/valterfi

WORKDIR /opt

# Add src to working directory
COPY pom.xml /opt/pom.xml
COPY src /opt/src

RUN apt-get update && apt-get install -y curl git maven libfontconfig && rm -rf /var/lib/apt/lists/*

RUN chmod +x /opt/src/main/resources/phantomjs

COPY ./start.sh /opt/

RUN chmod +x /opt/start.sh && \
# Build JAR
    mvn clean package -DskipTests=true

EXPOSE 8080 8082

CMD ["/opt/start.sh"]
