# kanboard-test

## Commands
    mvn clean test -DbaseURL=<host> -Dbrowser=<browser name> -Dheadless=<mode> -Dsuite=<suite> -Dlocal=<mode>
    - [baseURL] - Kanboard host adress (by default http://localhost:80)
    - [browser] - Selenide browser to test to (by default chrome)
    - [headless] - Selenide browser launch mode (by default true)
    - suite - Tests suites, choice of:
        - api - API methods tests suite
        - ui - UI scenarios tests suite
        - all - api and ui suites
    - [local] - by default true, for Jankins shold be set as false

    allure generate target/allure-results -o target/allure-report

    allure serve target/allure-results

## UI Tests screenshots

    build/reports/tests

## Jenkins results

![Alt text](jenkins/Screenshot%202023-08-01%20011658.png)