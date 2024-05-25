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
         stage('DOCKER IMAGES') {
            steps {
                sh 'docker build -t achatimage:v${BUILD_NUMBER} -f Dockerfile ./'
            }
        }
        stage('docker_deploy') {
            steps {
                sh 'docker login -u marwensn -p docker123'
                sh 'docker tag achatimage:v${BUILD_NUMBER} marwensn/achatimage:achatimage'
                sh 'docker push  marwensn/achatimage:achatimage'
            }
        }
        stage('docker_compose'){
            steps {
                sh 'docker-compose up -d'
            }
            }
    }
}
