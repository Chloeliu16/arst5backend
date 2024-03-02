# Team 5 Project Backend
This is the backend repo for the airline reservation system of Team 5, it uses JAVA spring boot framework and connects to a MySQL database and a REACT frontend.

It currently provides a simple search api `/search` which takes a `SearchRequest` of:
* `departureAirport`
* `arrivalAirport`
* `departureDate`

and returns the flights that meet the criteria.

## How to start a local backend server
1. Start a local MySQL instance and create a schema in MySQL Workbench
2. Run `flightdata_deltas-1.sql` (provided by the project) to create the tables
3. Update `application.properties` with the corresponding MySQL `url`, `username`, and `password`
4. Run the backend application

You will see logs like
```
2024-03-02T16:11:08.665-05:00  INFO 22188 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-03-02T16:11:08.876-05:00  WARN 22188 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2024-03-02T16:11:09.170-05:00  WARN 22188 --- [           main] .s.s.UserDetailsServiceAutoConfiguration :

Using generated security password: c5dfa1b3d-1erwed-sdfd5-bere37-2de87sfer2

This generated password is for development use only. Your security configuration must be updated before running your application in production.

2024-03-02T16:11:09.248-05:00  INFO 22188 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@11d557a5, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@55b5ce0f, org.springframework.security.web.context.SecurityContextHolderFilter@13e6ab86, org.springframework.security.web.header.HeaderWriterFilter@54d116d5, org.springframework.web.filter.CorsFilter@65067d37, org.springframework.security.web.csrf.CsrfFilter@2d21d12b, org.springframework.security.web.authentication.logout.LogoutFilter@14af9f51, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@4e6add8d, org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter@a3f1f32, org.springframework.security.web.authentication.ui.DefaultLogoutPageGeneratingFilter@74f9004c, org.springframework.security.web.authentication.www.BasicAuthenticationFilter@d60aa4, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@18b88f7, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@128ebca1, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@4f2a0909, org.springframework.security.web.access.ExceptionTranslationFilter@f9919a2, org.springframework.security.web.access.intercept.AuthorizationFilter@3d6c7152]
2024-03-02T16:11:09.285-05:00  INFO 22188 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
2024-03-02T16:11:09.290-05:00  INFO 22188 --- [           main] c.e.myexpedia.MyexpediaApplication       : Started MyexpediaApplication in 3.119 seconds (process running for 3.54)
```

We can test the local backend server by sending `GET` request `http://localhost:8080/search` in Postman with the following `Body` in `JSON` format:
```
{
    "departureAirport": "Atlanta (ATL)",
    "arrivalAirport": "Tucson (TUS)",
    "departureDate": "2023-01-02"
}
```
Note that it may need `Auth`, and by default, the `Username` is `user`, the `Password` is the security password shown in the logs when we start the application.

An example output is shown as follows:
```
{
    "departureFlights": [
        {
            "departdatetime": "2023-01-02T22:37:00.000+00:00",
            "arrivedatetime": "2023-01-03T02:39:00.000+00:00",
            "departairport": "Atlanta (ATL)",
            "arriveairport": "Tucson (TUS)",
            "flightnumber": "DL1600"
        },
        {
            "departdatetime": "2023-01-02T04:26:00.000+00:00",
            "arrivedatetime": "2023-01-01T08:30:00.000+00:00",
            "departairport": "Atlanta (ATL)",
            "arriveairport": "Tucson (TUS)",
            "flightnumber": "DL2317"
        },
        {
            "departdatetime": "2023-01-02T20:00:00.000+00:00",
            "arrivedatetime": "2023-01-03T00:07:00.000+00:00",
            "departairport": "Atlanta (ATL)",
            "arriveairport": "Tucson (TUS)",
            "flightnumber": "DL748"
        }
    ],
    "returnFlights": null,
    "success": true
}
```
If it is a round trip, then a returnDate will be passed, and we will return both the potential departure flights and the return flights, for example, 
```
{
    "departureAirport": "Atlanta (ATL)",
    "arrivalAirport": "Tucson (TUS)",
    "departureDate": "2023-01-02",
    "returnDate": "2023-01-04"
}
```
The output is
```
{
    "departureFlights": [
        {
            "departdatetime": "2023-01-02T22:37:00.000+00:00",
            "arrivedatetime": "2023-01-03T02:39:00.000+00:00",
            "departairport": "Atlanta (ATL)",
            "arriveairport": "Tucson (TUS)",
            "flightnumber": "DL1600"
        },
        {
            "departdatetime": "2023-01-02T04:26:00.000+00:00",
            "arrivedatetime": "2023-01-01T08:30:00.000+00:00",
            "departairport": "Atlanta (ATL)",
            "arriveairport": "Tucson (TUS)",
            "flightnumber": "DL2317"
        },
        {
            "departdatetime": "2023-01-02T20:00:00.000+00:00",
            "arrivedatetime": "2023-01-03T00:07:00.000+00:00",
            "departairport": "Atlanta (ATL)",
            "arriveairport": "Tucson (TUS)",
            "flightnumber": "DL748"
        }
    ],
    "returnFlights": [
        {
            "departdatetime": "2023-01-04T01:17:00.000+00:00",
            "arrivedatetime": "2023-01-04T04:42:00.000+00:00",
            "departairport": "Tucson (TUS)",
            "arriveairport": "Atlanta (ATL)",
            "flightnumber": "DL748"
        },
        {
            "departdatetime": "2023-01-04T18:00:00.000+00:00",
            "arrivedatetime": "2023-01-04T21:22:00.000+00:00",
            "departairport": "Tucson (TUS)",
            "arriveairport": "Atlanta (ATL)",
            "flightnumber": "DL819"
        },
        {
            "departdatetime": "2023-01-04T03:49:00.000+00:00",
            "arrivedatetime": "2023-01-03T07:15:00.000+00:00",
            "departairport": "Tucson (TUS)",
            "arriveairport": "Atlanta (ATL)",
            "flightnumber": "DL1600"
        }
    ],
    "success": true
}
```