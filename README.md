# Cayenne Maven Demo

## Prerequisites

You will need JDK 11+, [git](https://git-scm.com/downloads), Docker,
and [maven](https://maven.apache.org/download.cgi) installed for this demo. 
 
## Usage
- Clone this repo: `git clone https://github.com/stariy95/cayenne-maven-demo.git`
- Run demo DB via Docker Compose: `docker-compose up`
- Run `mvn cayenne:cdbimport` to create data map from DB
- Run `mvn cayenne:cgen` to generate classes 
- Run `mvn package` to compile Demo and create Jar file
- Run this demo `java -jar target/cayenne-maven-demo-1.0-SNAPSHOT.jar`

## Useful links
- [Including Cayenne in Project](https://cayenne.apache.org/docs/5.0/cayenne-guide/including-cayenne-in-project/)
- [DB-First Flow](https://cayenne.apache.org/docs/5.0/cayenne-guide/re-introduction/)
- [Creating project in IDEA](https://cayenne.apache.org/docs/4.2/getting-started-guide/#create-a-new-project-in-intellij-idea)
