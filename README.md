spring-boot-gradle-application
==============================

#What is it?

This application verifies if path exists between two given cities

# How to build it?

If you have gradle installed and under linux/mac, build this from project root directory:

    ./gradlew clean build


# How to run it?

If you have gradle installed and under linux/mac, run this from project root directory::

    ./gradlew bootRun


# How to test it?

After the server is running, go to(in web browser)

```
http://localhost:8080/connected?origin=source-city&destination=destination-city 
```
Example:

```
http://localhost:8080/connected?origin=Newark&destination=Philadelphia 
```

or in Postman, set the mapping type as GET and access this URI:

```
http://localhost:8080/connected?origin=source-city&destination=destination-city 
```
Example:

```
http://localhost:8080/connected?origin=Newark&destination=Philadelphia 
```


