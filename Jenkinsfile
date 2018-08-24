pipeline {
    agent any

    stages {
        stage('Trigger Job1') {
            steps {
                echo 'Triggering Job1..'
                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
            }
        }
        stage('Trigger Job2') {
            steps {
                echo 'Triggering Job2..'
                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
            }
        }
        stage('Trigger Job3') {
            steps {
                echo 'Triggering Job3....'
                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
            }
        }
    }
}
