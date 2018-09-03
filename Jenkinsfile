pipeline {
    agent any

    stages {
/*        stage('Trigger Job1') {
            steps {
                echo 'Triggering Job1..'
                script {
                    def path = pwd()
                    checkout([$class: 'GitSCM', branches: [[name: '*\/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cd286c7e-b875-4a15-b0e5-e54f0ec6469a', url: 'git@github.com:priyanshutomar/testrepo2.git']]])
                    echo "${path}\n"
                    println(new File(path + "/csvFile.csv").readLines())
                }
//                build job: 'slaveJob', parameters: [string(name: 'param1', value: 'ValueOfParam')]
            }
        } */
        stage('Trigger Job2') {
            steps {
                echo 'Triggering Job2..'
                script {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cd286c7e-b875-4a15-b0e5-e54f0ec6469a', url: 'git@github.com:priyanshutomar/testrepo2.git']]])
                    List<String> content = new File("${path}/csvFile.csv").readLines()
                    def allParams = []
                    content.eachWithIndex { String line, int i ->
                        String[] vals = line.split(",")
                        def params = []
                        vals.eachWithIndex { String val, int j ->
                            if (val != null || val.length() > 0) {
                                params.add(string(name: "${content.get(0).split(",")[j]}", value: "${vals[j]}"))
                            }
                        }
                        allParams.add(params)
                    }
                    allParams.each {param ->
                        stage("Test ") {
                            build job: 'slaveJob', parameters: param
                        }
                    }
                }
            }
        }
    }
}
