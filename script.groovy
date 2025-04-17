def buildJar() {
    echo '🔧 Building the application...'
    sh 'mvn package'
}

def buildImage() {
    echo '🔧 Building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) { 
    sh 'docker build -t cdickersoncloudcoder/demo-app:jma-2..1 .'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push cdickersoncloudcoder/demo-app:jma-2.1'
                }
}

def deployImage() {
    echo 'Deploying the application...'
    
}

return this