# YSNoteSOAP
YSNoteSOAP is a JAX-WS/SOAP application for add, list, edit, delete operations notes.

This project developed with Java(JDK 14), JAX-WS(SOAP), Hibernate(JPA implementation), HSQLDB and Maven.

## [Download](https://github.com/yusufsefasezer/YSNoteSOAP/archive/master.zip)

## How to run

Maven must be installed to run this application.

### Server

Run the following commands step by step.

```
cd server
mvn package
java -jar target\server.jar
```

### Client

Run the following commands step by step.

```
cd client
mvn package
java -jar target\client.jar
```

## Screenshot

- [Server](screenshot/server.png)
- [Client](screenshot/client.png)
- [Client Add](screenshot/client-add-note.png)
- [Server Add](screenshot/server-add-note.png)
- [Client List](screenshot/client-list-note.png)
- [Server List](screenshot/server-list-note.png)
- [Client Count](screenshot/client-count-note.png)
- [Server Count](screenshot/server-count-note.png)
- [Client Arguments](screenshot/client-arguments.png)

# License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details

Created by [Yusuf Sezer](https://www.yusufsezer.com)
