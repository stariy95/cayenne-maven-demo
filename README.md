# Cayenne Maven Demo

## Prerequisites

You will need [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), 
[git](https://git-scm.com/downloads) and [maven](https://maven.apache.org/download.cgi) for this demo. 
 
## Usage
- Clone this repo: `git clone https://github.com/stariy95/cayenne-maven-demo.git`

- Create demo DB using on of `sql` scripts provided in `src/main/resources` directory

- Setup DB connection in `pom.xml`:
```xml
<dataSource>
    <url>jdbc:mysql://localhost/demo</url>
    <driver>com.mysql.jdbc.Driver</driver>
    <username>root</username>
    <password>password</password>
</dataSource>
```
and in `src/main/resources/cayenne-project.xml` (edit DataNode via Modeler)

- Run `mvn cayenne:cdbimport` to create data map from DB
- Run `mvn cayenne:cgen` to generate classes 
- Run `mvn package` to compile Demo and create Jar file
- Run this demo `java -jar target/cayenne-maven-demo-1.0-SNAPSHOT.jar`

## Usefull links
- [Including Cayenne in Project](http://cayenne.apache.org/docs/4.0/cayenne-guide/including-cayenne-in-project.html#maven-projects)
- [DB-First Flow](http://cayenne.apache.org/docs/4.0/cayenne-guide/re-introduction.html)
- [Creating project in IDEA](http://cayenne.apache.org/docs/4.0/tutorial/getting-started-part2.html#d0e47)
