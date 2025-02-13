pipeline {
	agent any
	tools {
		maven 'maven 3.9.9'
		jdk 'Java JDK 17'
	}
	stages {
		stage("clean") {
			steps {
				echo "Start Clean"
				sh "mvn clean"
			}
		}
		stage("test") {
			steps {
				echo "Start Test"
				sh "mvn test"
			}
			
		}
		stage("build") {
			steps {
				echo "Start build"
				sh "mvn install -DskipTests"
			}
		}
		stage('sonar') {
            environment {
                SONAR_HOST_URL = "http://localhost:9000"
                SONAR_AUTH_TOKEN = credentials("sonarqube_token")
            }
            steps {
				echo "Start sonar"
              	sh "mvn sonar:sonar -Dsonar.projectKey=maven-project-jenkins-lab -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=$SONAR_AUTH_TOKEN"
            }
        }
        stage('archive artifact') {
			steps {
				archiveArtifacts artifacts: 'target/.*war'
			}
		}
        stage('deployment') {
			steps {
				deploy adapters: [tomcat9(url: "http://localhost:8090/", credentialsId: "tomcat")],
				war: 'target/*.war',
				contextPath: "jenkins_maven.eclipse"
			}
		}
	}
}