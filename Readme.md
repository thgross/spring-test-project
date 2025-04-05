# spring-test-project

## DB

siehe dazu auch https://chatgpt.com/c/67f14bee-8520-800a-b045-d10678afeeda

```yaml
spring:
    jpa:
        hibernate:
            ddl-auto: update
```

- Entwicklungsumgebung: `update` oder `create-drop`
    - `update`: aktualisiert automatisch das Datenbankschema basierend auf deinen Entities, ohne Daten zu löschen →
      ideal für lokale Entwicklung.
    - `create-drop`: erstellt das Schema beim Start und löscht es beim Shutdown → gut für Tests und experimentelle
      Projekte.
- Produktionsumgebung: Verwende niemals `update`, `create` oder `create-drop`.
  Stattdessen:
    - `validate`: prüft beim Start, ob das Schema zur Entity-Struktur passt – bricht bei Abweichungen ab → gut zur
      Absicherung
    - `none`
