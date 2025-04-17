pipeline {
    agent any
    tools{
        maven 'maven-3.9.1'
    }

    stages {
        stage('Build jar') {
            steps {
                echo '🔧 Building the application...'
                sh 'mvn package'
            }
        }

        stages {
        stage('Build image') {
            steps {
                echo '🔧 Building the docker image...'
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER' )]) { 
                    sh 'docker build -t  cdickersoncloudcoder/demo-app:jma-2.0 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push cdickersoncloudcoder/demo-app:jma-2.0'

                }
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Deploying the application...'
                // Add your deploy commands here
                // For example: sh './deploy.sh' or 'scp target/app.jar user@server:/app/'
            }
        }
    }
}
