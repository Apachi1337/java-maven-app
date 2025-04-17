def buildApp() {
    echo 'Building the project...'
}

def testApp() {
    echo 'Running tests...'
}

def deployApp() {
    echo 'Deploying the application...'
    echo "deploying version ${params.VERSION}"
}

return this