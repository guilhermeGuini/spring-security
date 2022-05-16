# Spring security for web applications

Example project to simulate the use of spring security in a web application.

1. Was used an in-memory database with users and it's roles.
2. Two endpoints path, secure and unsecure where all calls for unsecure/** path doesn't need authentication.
3. Used some annotations to configure the security
    ```
   // enable spring security
    @EnableWebSecurity
   // enable spring security annotations, E.g @Secured
    @EnableGlobalMethodSecurity(securedEnabled = true)
    ```
4. Paths with different permissions, E.g SecureRestApi class