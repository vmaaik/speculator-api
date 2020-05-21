@Library('shared') _

pipeline {
    agent any
    stages {
        stage('Start') {
            steps {
                script {
                    log.info 'Starting'
                    log.warning 'Nothing to do!'
                }
            }
        }

        stage('Unit Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

    }
}