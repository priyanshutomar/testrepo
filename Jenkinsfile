pipeline {
    agent any

    stages {
        stage('Trigger Job1') {
            steps {
                echo 'Triggering Job1..'
                script {
                    def path = pwd()
                    echo "${path}"
                }
                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
            }
        }
        stage('Trigger Job2') {
            steps {
                echo 'Triggering Job2..'
                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
                script {
                    for (int i = 0; i < 3; i++) {
                        stage("Test ${i}") {
                            echo "running stage #${i}"
                        }
                    }
                }
            }
        }
    }
}
