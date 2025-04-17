pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo '🔧 Building the application...'
                sh 'echo Build step running...'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                sh 'echo Test step running...'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deploying the application...'
                sh 'echo Deploy step running...'
            }
        }
    }
}