FROM eclipse-temurin:21-jdk

WORKDIR /app

# Kopiera all källkod inklusive META-INF
COPY . .

# Kompilera Java-koden
RUN javac -d out $(find . -name "*.java")

# Lägg till manifest
RUN echo "Main-Class: se.iths.app.ConverterApplication" > out/manifest.txt

# Kopiera META-INF/services till rätt plats i output-mappen
RUN mkdir -p out/META-INF/services && \
    cp META-INF/services/se.iths.spi.Converter out/META-INF/services/

# Bygg JAR med manifest och META-INF
RUN jar cfm app.jar out/manifest.txt -C out .

CMD ["java", "-jar", "app.jar"]
