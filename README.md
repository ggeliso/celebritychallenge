# celebritychallenge
Find the celebrity

This challenge was developed with this assumption:
1. The celebrity does not know anybody, for them, the celebrity will be the unique person that will have a value true in a field
2. The other memebers of the team will have a false value in a field.

For running the application bear your mind the next:
1. The data are stored in-memory database, for that, it was used H2.
2. The data are inserted in a table called people.
3. Tha people table has three field: id, name and is_celebrity.
4. The data are inserted in the table, using a script once the application was running.
5. This script you can find in the resources package, the file is called data.sql
6. This script will just have only record with a value true in the field is_celebrity which allows to identify the celebrity.
7. The others members of the team will have a value false in the field is_celebrity.
8. The application is running with Java 11.
9. The application has only one endpoint which can be accessed through for this url: localhost:8080/celebrity/findcelebrity/{name}
10. Where {name} is the person that you want to know whether is the celebrity or not.
11. Once the endpoint was executed through the url, it will return a string where show us a message if the name sent is the celebrity or not.
12. The application was developed with IntelliJ idea and the project was created by Maven.
