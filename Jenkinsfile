#!groovy

node {

    try {
        stage('Test') {
            echo 'Run tests'
            bat 'mvn clean test'
        }
    } catch (e) {
        currentBuild.result = "FAILED"
        throw e
    } finally {
        stage('Tests results') {
            echo 'Functional tests reports'
            step([$class: 'CucumberReportPublisher', jsonReportDirectory: 'target/', fileIncludePattern: '*.json'])
            cucumberSlackSend channel: 'cucumber_report', json: 'target/cucumber.json'

        }
    }
}