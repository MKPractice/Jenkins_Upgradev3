pipeline {
      agent any
      stages {
            stage('Build an Application'){
                  steps{
                        sh 'mvn -f java-tomcat-sample/pom.xml clean package'
                  }
		  post {
		  success {
		        echo "Archiving the Artifacts"
			archiveArtifacts artifacts: '**/*.war'
			}
			}
			}
            stage('Deploy in Staging Environment'){
                  steps{
                        build job: 'Deploy_App_Staging_Environment'
                  }
            }
            
	    stage('Deploy in Production Environment'){
                  steps{
                        timeout(time:5, unit: 'DAYS'){
			input message: 'DEPLOY PRODUCTION ENVIRONMENT?'
                  }
                       build job: 'Deploy_App_Production_Environment'
		       }
                  }
            }
      }


