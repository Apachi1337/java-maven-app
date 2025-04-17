pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '' )
        booleanParam(name: 'executeTests', defaultValue:true, description:'')
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                // Add your build commands here, e.g., sh 'npm install' or sh 'mvn clean install'
            }
        }

        stage('Test') {
            when{
                expression {
                    params.executeTests
                }
            }
            steps {
              
                echo 'Running tests...'
                // Add test commands, e.g., sh 'npm test' or sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                echo "deploying version ${params.VERSION}"
            }
        }
    }
}

