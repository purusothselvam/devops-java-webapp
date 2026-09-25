pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Maven Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Maven Package') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t devops-webapp:${BUILD_NUMBER} .'
            }
        }

        stage('Deploy with Ansible') {
    steps {
        sh 'ansible-playbook -i /etc/ansible/hosts ansible/deploy.yml'
    }
}

        stage('Verify') {
            steps {
                sh '''
                    ansible -i ansible/inventory app \
                    -m shell \
                    -a "curl -f http://127.0.0.1:8081"
                '''
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }

        failure {
            echo 'Deployment failed!'
        }
    }
}
