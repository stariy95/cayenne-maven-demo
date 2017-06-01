# Cayenne Maven Demo

## Prerequisites

You will need [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), 
[git](https://git-scm.com/downloads) and [maven](https://maven.apache.org/download.cgi) for this demo. 
 
## Usage
- Clone this repo: `git clone https://github.com/stariy95/cayenne-maven-demo.git`
- Setup DB connection in `pom.xml`:
```xml
<dataSource>
    <url>jdbc:mysql://localhost/db_name</url>
    <driver>com.mysql.jdbc.Driver</driver>
    <username>root</username>
    <password>password</password>
</dataSource>
```
- Setup filters in `pom.xml`:
```xml
<dbImport>
    <!-- cdbimport settings -->
</dbImport>
```
- Run `mvn cayenne:cdbimport` to create data map from DB
- Run `mvn cayenne:cgen` to generate classes 

## Usefull links
- [Including Cayenne in Project](http://cayenne.apache.org/docs/4.0/cayenne-guide/including-cayenne-in-project.html#maven-projects)
- [DB-First Flow](http://cayenne.apache.org/docs/4.0/cayenne-guide/re-introduction.html)
- [Creating project in IDEA](http://cayenne.apache.org/docs/4.0/tutorial/getting-started-part2.html#d0e47)
