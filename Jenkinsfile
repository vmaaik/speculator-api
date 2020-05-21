pipeline {
  agent any
  stages {
    stage('Start') {
      steps {
        echo 'Starting build step'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn clean build'
      }
    }

  }
}