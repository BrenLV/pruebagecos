# pruebagecos

RESTful API implementation with JAX-RS.

## Installation

Create database postgres script BD.sql
Use IDE eclipse [IDE eclipse](https://www.eclipse.org/downloads/)


## Configure standalone.xml for Wildfly server to connect to the database postgres

```bash
<datasources>
	<datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
		<connection-url>jdbc:postgresql://localhost:5433/gecosdb</connection-url>
			<driver>postgresql</driver>
				<security>
                    <user-name>postgres</user-name>
                    <password>postgres</password>
                </security>
            </datasource>
        <drivers>
            <driver name="postgresql" module="org.postgresql">
                <driver-class>org.postgresql.Driver</driver-class>
            </driver>
        </drivers>
</datasources>
```

## License

[MIT](https://choosealicense.com/licenses/mit/)