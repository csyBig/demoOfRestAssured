pipeline {
    agent any

    stages {
        stage ('mvn clean') {

            steps {
                withMaven(maven : 'maven_3_5_0') {
                    sh 'mvn clean test'
                }
            }
        }

        stage ('Testing Stage') {

            parallel {
                stage('first parallel') {
                    steps {
                        echo 'first stage'
                    }
                }

                stage('seconde parallel') {
                    steps {
                        echo 'second stage'
                        }
                }
                stage(){
                        steps {
                                withMaven(maven : 'maven_3_5_0') {
                                    sh 'mvn clean test'
                                }
                            }
                }
             }
        }
    }



}