# purecode
This service shows the difference in error handling between Java, Kotlin and Kotlin + arrow.kt

Main point of interest for the curious should be the contract between `UserService` and `UserController`.
Switching between `main`, `kotlin` and `kotlin-arrow` branches will show changes in the signature of `UserService.getById()` and different ways of handling errors:
- on `main` we can see Java code with exception handling in `ExceptionHandler`
- on `kotlin` we make use of Kotlin's nullable type system rather than throwing exceptions which makes things a bit better
- the `kotlin-arrow` branch will potentially show the reader how making the errors part of the function signature makes the world a better place

## Run
```bash
./graldew bootRun
```
This will spin up the service and make it available on port 8080.

We've opted in for H2 in-memory DB which is run as part of the service.
H2 console will be available on http://localhost:8080/h2-console.
The JDBC URL you need to connect to will change from instance to instance and can be found inside the logs during startup, e.g. jdbc:h2:mem:3e4e4073-1b8a-43ee-854c-3e7683cd5f6b.
