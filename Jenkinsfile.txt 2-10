def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'Choose the version')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'Execute tests?')
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
                echo "Building app..."
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
                    // Capture the environment choice from the user
                    env.ENV = input(
                        message: "Select the environment to deploy to...",
                        ok: "Env selected...",
                        parameters: [
                            choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], description: 'Choose the deployment environment')
                        ]
                    )
                    // Deploy to the selected environment
                    gv.deployApp()
                    echo "Deploying to ${env.ENV}"
                }
            }
        }
    }
}
