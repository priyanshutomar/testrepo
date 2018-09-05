def call(String filePath) {
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'cd286c7e-b875-4a15-b0e5-e54f0ec6469a', url: 'git@github.com:priyanshutomar/testrepo2.git']]])
    def content = new File(filePath).readLines()
    content.eachWithIndex { String line, int i ->
        def vals = line.split(',', -1)
        def params = []
        vals.eachWithIndex { String val, int j ->
            if (!(val == null || val == "")) {
                params.add(string(name: "${content.get(0).split(',', -1)[j]}", value: "${vals[j]}"))
            }
        }
        if (i != 0) { 
            stage(vals[0]) {
                build job: 'slaveJob', parameters: params
            }
        }
    }
}

return this;
