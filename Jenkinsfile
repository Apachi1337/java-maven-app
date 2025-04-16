def gv

pipeline {
    agent any

    parameters {
        choice(name: 'VERSION', 
               choices: ['1.1.0', '1.2.0', '1.3.0'], 
               description: 'Select the version to deploy')
        
        booleanParam(name: 'executeTests', 
                     defaultValue: true, 
                     description: 'Should tests be executed?')
    }

    environment {
        SCRIPT_PATH = 'script.groovy'
    }

    stages {
        stage('Init') {
            steps {
                script {
                    echo '🟡 Initializing...'
                    gv = load "${SCRIPT_PATH}"
                }
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
                    return params.executeTests
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage('Deploy') {
            input{
                message "select the environment to deploy to"
                ok "Done"
                parameters{
                    choice(name: 'ENV', 
               choices: ['dev', 'staging', 'production'], 
               description: 'Select the version to deploy')

                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }
}