pipeline {
      agent any


      stages {
         stage('Build') {
            steps {
               sh './gradlew clean compileJava'
               sh './gradlew clean assemble'
            }
         }
         stage('Deploy'){
            steps{
                pushToCloudFoundry cloudSpace: 'jpdoherty-cnt', credentialsId: 'ede9b831-3f97-4e71-90a6-4356042f4a70', organization: 'solstice-org', target: 'https://api.run.pivotal.io'
            }
         }
      }
  }