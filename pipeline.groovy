#!groovy

pipeline {

    agent any
    
stages {
    stage('First') {
        steps {
            script {
                echo "Start"
            }
        }
    }
    
    stage('CodeCraft git checkout') {
        steps {
            sh "echo 'Checking out from the selected branch: $BRANCH'"
            checkout([$class: 'GitSCM', branches: [[name: "*/$BRANCH"]], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CleanBeforeCheckout'], [$class: 'CloneOption', depth: 0, noTags: false, reference: '', shallow: true, timeout: 30], [$class: 'CheckoutOption', timeout: 30]], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/digitalnerd/web-hooks-test.git']]])
                }
            }
        }
    }
}
}
