def gv

pipeline {
    agent any

    tools {
        maven 'maven-3.9'
    }

    stages {
      stage('increment version') {
          steps {
              script {
                  echo 'incrementing app version'
                  sh 'mvn build-helper:parse-version versions:set \
                  -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                  versions:commit'
                  def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                  def version = matcher[0][1]
                  env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }

      stage('build app') {
          steps {
              script {
                  echo 'building the applcation ...'
                  sh 'mvn clean package'
                }
            }
        }

      stage('build image') {
          steps {
              script {
                  echo 'building the docker image ...'
                  withCredentials([usernamePassword(credentialsId: 'dockerhub_auth', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                      sh "docker build -t ${DOCKER_USERNAME}/demo-app:${IMAGE_NAME} ."
                      sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
                      sh "docker push ${DOCKER_USERNAME}/demo-app:${IMAGE_NAME}"
                  }
                }
            }
        }

      stage('deploy app') {
          steps {
              script {
                  echo 'deploying the application ...'
                }
            }
        }
      
      stage('commit version update') {
          steps {
              script {
                  withCredentials([usernamePassword(credentialsId: 'gitlab_auth', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                      sh 'git config --global user.email "tiberiu.purcel@gmail.com"'
                      sh 'git config --global user.name "tdascal"'

                      sh 'git status'
                      sh 'git branch'
                      sh 'git config --list'

                      sh "git remote set-url origin https://${USER}:${PASS}@gitlab.com/tdascal/java-maven-app.git"
                      sh 'git add .'
                      sh 'git commit -m "ci: version bump"'
                      sh 'git push origin HEAD:jenkins-jobs'
                    }
                }
            }
        }
    }
}
