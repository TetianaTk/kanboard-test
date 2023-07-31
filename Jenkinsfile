pipeline {
    agent any

    parameters {
        string defaultValue: 'http://1920-93-72-68-223.ngrok.io', name:'baseURL'
        choice choices: ['api', 'ui', 'all'], name:'suite'
        booleanParam defaultValue: false, name: 'local'
    }

    tools {
        // Install the Maven version configured as "Apache Maven 3.8.5" and add it to the path.
        maven 'Apache Maven 3.8.5'
        jdk 'JDK_17'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                sh 'java --version'
                echo "Build number $env.BUILD_NUMBER"
                // Run Maven on a Unix agent.
                sh "mvn clean test -DbaseURL=$baseURL -Dsuite=$suite -Dlocal=$local"
            }

            post {
                always{
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results:[[path: 'target/allure-results']]
                        ])
                }
            }
        }
    }
}