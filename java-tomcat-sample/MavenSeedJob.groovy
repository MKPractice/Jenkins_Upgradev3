job('First_Maven_Job_Via_DSL')
 {
  description("This is first maven job creating and configuring through DSL on ${new Date()}, This code is on GIT HUb")
    scm 
      {
        ("https://github.com/MKPractice/Jenkins_Upgradev3.git")
      }
      triggers
        {
	  scm("* * * * *")
	}
	steps
	  {
	    maven('clean package','java-tomcat-sample/pom.xml')
	  }
	  publishers
	  {
	    archivingArtifacts '**/*.jar'
	    }
 }

