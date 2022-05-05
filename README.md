# Евгений Борисов — Spring-построитель

https://www.youtube.com/watch?v=rd6wxPzXQvo

## Quickstart

```sh
mvn exec:java -Dexec.mainClass=com.epam.Main --quiet
```

## Problem

```
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
```

Solution is adding 2 new dependencies to `pom.xml`.

```xml
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
  <version>1.7.36</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-simple</artifactId>
  <version>1.7.36</version>
</dependency>
```
