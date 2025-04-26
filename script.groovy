def buildJar() {
    echo "Building application....."
    sh 'mvn package'
}

def buildImage() {
    echo "Building Docker image...."
    withCredentials([usernamePassword(credentialsId: "docker-hub-repo", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t cdickersoncloudcoder/demo-app1.3:2.2 .'  // Building docker image
        sh 'echo $PASS | docker login -u $USER --password-stdin'  // Login to Docker Hub
        sh 'docker push cdickersoncloudcoder/demo-app1.3:2.2'  // Push the image to Docker Hub
    }
}

def deployApp() {
    echo "Deploying the app....."
    // You can add further deployment steps here (e.g., Kubernetes, AWS ECS, etc.)
}

return this