# Projekt Workspace - CoWorkConnect

Workspace ist eine Webapplikation, die es Mitgliedern ermöglicht, die Angebote des Coworkingspaces digital zu erfassen und zu nutzen.

## Änderungen gegenüber der Planung

Lorem Ipsum Dolor

## TestDataService-Klasse

Die Klasse 'TestDataService', im Pfad:'', ist verantwortlich für die Generierung von Testdaten. Sie enthält eine Methode namens 'generateTestData', die beim Start der Applikation im Entwicklungsmodus automatisch aufgerufen wird. In dieser Methode werden Instanzen von verschiedenen Modellen erstellt, die generierten Testdaten umfassen die folgenden Entitäten:
- ApplicationUser
- CoworkingSpace
- Booking

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