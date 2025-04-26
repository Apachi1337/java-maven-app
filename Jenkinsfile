def gv // Declare the variable globally

pipeline {
    agent any
    tools {
        maven "maven-3.9"
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"  // Loading the Groovy script into gv
                }
            }
        }
        stage('Build jar') {
            steps {
                script {
                    gv.buildJar()  // Calling the buildJar function from the loaded script
                }
            }
        }
        stage('Build image') {
            steps {
                script {
                    gv.buildImage()  // Calling the buildImage function from the loaded script
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    gv.deployApp()  // Calling the deployApp function from the loaded script
                }
            }
        }
    }
}