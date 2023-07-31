# kanboard-test

## Commands

    docker compose up -d

    mvn clean test -Dsuite=<suite> [-DbaseURL=<host>] [-Dbrowser=<browser_name>] [-Dheadless=<mode>] [-Dlocal=<mode>]
    
    - suite - Tests suites, choice of:
        - api - API methods tests suite
        - ui - UI scenarios tests suite
        - all - api and ui suites
    - [baseURL] - Kanboard host adress (by default http://localhost:80)
    - [browser] - Selenide browser to test to (by default chrome)
    - [headless] - Selenide browser launch mode (by default true)
    - [local] - by default true, for Jenkins shold be set as false

    allure generate target/allure-results -o target/allure-report

    allure serve target/allure-results

## UI Tests screenshots

    build/reports/tests

## Jenkins results

![Alt text](jenkins/Screenshot%202023-08-01%20011658.png)