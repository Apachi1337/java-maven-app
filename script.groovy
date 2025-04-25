def buildApp() {
    echo 'build the app....'
}

def testApp() {
    echo 'testing the app....'
}

def deployApp() {
    echo "deploying the app....."
    echo "deploying VERSION ${params.VERSION}"
}

