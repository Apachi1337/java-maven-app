pipeline {
    agent any
    tools {
        maven 'maven-3.11'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }
                stage("build image") {
            steps {
                script {
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PAASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t mashaab/demo-app:jam-1.1 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push mashaab/demo-app:jam-1.1'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }
    }
}

