# Converter Application 

Det här är en enkel Java-konsolapplikation som kan konvertera värden mellan olika enheter, t.ex. kilometer till meter och grader till Fahrenheit. Applikationen är byggd med Java och paketerad i en Docker-container. 

---

## Funktioner

- Kilometer till meter
- Celsius till Fahrenheit

---

## Kom igång

### Bygga och köra med Docker

Bygg Docker-imagen:


docker build -t converter-app .

docker run -it converter-app
