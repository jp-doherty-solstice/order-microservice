pipeline {
      agent any


      stages {
         stage('Build') {
            steps {
               sh 'gradle clean compileJava'
               sh './gradlew clean assemble'
            }
         }
         stage('Deploy'){
                    steps{
                        sh 'cf push order-microservice -p ./build/libs/order-microservice-0.0.1-SNAPSHOT.jar'
                    }
         }
      }
  }