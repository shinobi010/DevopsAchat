pipeline {
    agent any

    stages {
        stage('mvn_clean') {
            steps {
                sh 'mvn clean'
            }
        }
        stage('mvn_compile') {
            steps {
                sh 'mvn compile'
            }
        }
       stage('SonarQube Analysis') {
            steps {
                sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar"
            }
        }
        stage('mvn_test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('mvn_deploy') {
            steps {
                sh 'mvn deploy'
            }
        }
        stage('docker_deploy') {
            steps {
                sh 'docker login -u marwensn -p bWFyd2Vuc246ZGNrcl9wYXRfRU11NWlMSGVmUlJISHV6QTlDcEJqYXZ5RDc4'
                sh 'docker run -d -p 8080:8080 achat'
            }
        }
        stage('docker_compose'){
            steps {
                sh 'docker-compose up -d'
            }
            }
    }
}
