pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                echo "Running tests..."
                echo "Executing pipeline for $BRANCH_NAME"
            }
        }
        stage('Build') {
            when{
                expression{
                    BRANCH_NAME == "master"
                }
            }
            steps {
                echo "Building the application..."
            }
        }
        stage('Deploy') {
            when{
                expression{
                    BRANCH_NAME == "master"
                }
            }
            steps {
                echo "Deploying the application..."
            }
        }
    }
}