# Projekt Workspace - CoWorkConnect

Workspace ist eine Webapplikation, die es Mitgliedern ermöglicht, die Angebote des Coworkingspaces digital zu erfassen und zu nutzen.

## Änderungen gegenüber der Planung

Die Planung eines Programmierprojektes läuft nie perfekt ab, auch in diesem Fall. Es mussten während der Umsetzung dieses Projektes einige Änderungen gegenüber der Planung vorgenommen werden, dazu zählen:
- Die Pfadnamen, diese mussten angepasst werden, weil es sonst zu Komplikationen zwischen den Endpunkten gekommen wäre und weil die neuen Pfadnamen übersichtlicher sind als die ursprünglich geplanten.
- Der Grundsatz der Vererbung. Dass heisst, dass es nun nur einen User, den ApplicationUser gibt. Dieser User besitzt entweder den Besucher, Mitglieder, oder Administrator-Status. In der Planung waren 3 User, welche von einander erben vorgesehen.

## Projekt aufsetzen

1. Erstelle eine Kopie (fork) von diesem Projekt.
1. Stelle sicher, dass Docker installiert ist und läuft.
1. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
1. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.

## Projekt starten

1. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Testdaten

Die Klasse 'TestDataService', ist verantwortlich für die Generierung von Testdaten. Sie enthält eine Methode namens 'generateTestData', die beim Start der Applikation im Entwicklungsmodus automatisch aufgerufen wird. In dieser Methode werden Instanzen von verschiedenen Modellen erstellt, die generierten Testdaten umfassen die folgenden Entitäten:
- ApplicationUser
- CoworkingSpace
- Booking

## End zu End-Tests (E2E)

Die End zu End-Tests sind in 5 verschiedene Collections aufgeteilt, diese sind:
- (15) Registrierung, Authenzifizierung
- (16) Verwaltung der eigenen Buchungen (Mitglied)
- (17) Verwaltung der Buchungen
- (18) Verwaltung von Mitgliedern
- (19) Zusätzliche Anforderungen

Die Collections können im Ordner PostmanCollections gefunden werden. Die .json Dateien können dann ganz einfach auf postman importiert und ausgeführt werden. 

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`