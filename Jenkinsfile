def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
                echo "building app....."
            }
        }
        stage('Build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('Test') {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage('Deploy') {
           
            steps {
                script {
                    env.ENV = input message: "select the environment to deploy to..." , ok "Env selected...", parameters: [choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], description: '')] 

                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                    
                }
            }
        }
    }
}
