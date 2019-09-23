pipeline {
    agent any

    stages {
        stage('Build') {
            parallel{
                stage('Build:Module1') {
                    steps {
                        sh 'echo Build Module1 stage ...'
                    }
                }
                stage('Build:Module2') {
                    steps {
                        sh 'echo Build Module2 stage ...'
                    }
                }
                stage('Build:Module3') {
                    steps {
                        sh 'echo Build Module3 stage ...'
                    }
                }
            }
        }
        stage('Test'){
            steps {
                sh 'echo Test stage ...'
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo Deploy stage ...'
            }
        }
    }
  }