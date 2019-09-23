pipeline {
    agent any
    def mvnHome = tool 'M3'
    stages {


        stage('init'){
            steps {
                sh 'echo init stage ...'
            }
        }
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
                        sh 'mvn clean test'
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

    }
  }