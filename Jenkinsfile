#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [$class: 'GitSCMSource', 
    remote: 'https://gitlab.com/devops-bootcamp8333314/entering-learning-phase-3-devops-core/jenkins-shared-library.git',
    credentialsId: 'gitlab-credentials']
)

def gv

pipeline {   
    agent any

    tools {
        maven 'maven-3.9'
    }

    stages {
        stage("Init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("Build Jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage("Build and Push Image") {
            steps {
                script {
                    buildImage 'cdickersoncloudcoder/demo-app1.3:3.0'
                    dockerLogin()
                    dockerPush 'cdickersoncloudcoder/demo-app1.3:3.0'
                }
            }
        }
        
        stage("Deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }               
    }
}