pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/18aishuaishu/FarmFresh.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                // Example: sh 'npm install' or 'mvn package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Example: sh 'npm test' or 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                // Example: Docker push, Azure CLI deploy, etc.
            }
        }
    }
}
