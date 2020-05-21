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
        bat 'mvn clean install -Dlicense.skip=true'
      }
    }

  }
}