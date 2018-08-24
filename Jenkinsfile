pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
