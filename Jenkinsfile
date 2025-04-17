pipeline {
    agent any

    environment {
        RECIPIENT = 'oguzhanmguclu@gmail.com'
        GIT_CREDENTIALS_ID = 'dc56b904-2c60-4991-91e7-e86def0e981b'  // Jenkins'teki credential ID
        REPO_URL = 'https://github.com/cansu-altunsoy/Jenkis.git'  // Repo URL
    }

    stages {
        stage('Checkout') {
            steps {
                // GitHub reposundan checkout alıyoruz
                git credentialsId: "${env.GIT_CREDENTIALS_ID}", url: "${env.REPO_URL}", branch: "${env.BRANCH_NAME}"
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    echo 'Running Cucumber tests...'

                    // Eğer Maven kullanıyorsanız, Cucumber testlerini çalıştırmak için şu komutu kullanabilirsiniz:
                    bat 'mvn clean test -Dcucumber.options="--tags @E2E"'  // Cucumber test tag'ine göre filtreleme yapılabilir
                }
            }
        }

        stage('Push to GitHub') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo 'Tests passed, pushing to GitHub...'
                withCredentials([usernamePassword(credentialsId: "${env.GIT_CREDENTIALS_ID}", usernameVariable: 'GIT_USER', passwordVariable: 'GIT_PASS')]) {
                    bat """
                        git config --global user.email "jenkins@example.com"
                        git config --global user.name "Jenkins CI"
                        git remote set-url origin https://${env.GIT_USER}:${env.GIT_PASS}@${env.REPO_URL.replace('https://', '')}
                        git add .
                        git diff --cached --quiet || git commit -m "Automated commit by Jenkins after successful build"
                        git push origin ${env.BRANCH_NAME}
                    """
                }
            }
        }
    }

    post {
        failure {
            mail to: "${env.RECIPIENT}",
                 subject: "🚨 Build FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: """\
Build başarısız oldu.

Detaylar: ${env.BUILD_URL}console
"""
        }
    }
}
