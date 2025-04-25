def buildJar() {
    echo "building the application ..."
    sh 'mvn package'
}

def buildImage() {
    echo "building the application's image for Docker ..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub_auth', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tdascal/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push tdascal/demo-app:jma-2.0'
    }
}

def deployApp() {
    echo 'deploying the application ...'
}

return this