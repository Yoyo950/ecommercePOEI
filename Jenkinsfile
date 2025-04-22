pipeline {
    parameters {
            string(name: 'TEST_KEYS', defaultValue: '', description: 'The keys of the tests imported and executed')
            choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'The browser used for the tests')
            booleanParam(name: 'IS_HEADLESS', defaultValue: false, description: 'Define if we run in headless')
    }

    environment {
        PATH_CUCUMBER_FILE = 'target/cucumber.json'
        PATH_ZIP = "features.zip"
        PATH_EXPORT = "src/test/resources/features/distant"
        BRWSR = '%BROWSER%'
        HL = '%IS_HEADLESS%'
        JIRA_IDS = credentials('JIRA_IDS')
    }
    agent any

    stages {
        stage('Init') {
            steps {
                script {
                    bat 'curl -H "Content-Type: application/json" -X POST --data "{ \\"client_id\\": \\"%JIRA_ID_USR%\\",\\"client_secret\\": \\"%JIRA_ID_PSW%\\" }"  https://xray.cloud.getxray.app/api/v2/authenticate >token.txt'
                    bat """
                        set /p TOKEN=<token.txt
                        curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer %TOKEN%" -o %PATH_ZIP% "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=%TEST_KEYS%"
                        mkdir -p %PATH_EXPORT%
                        unzip -o %PATH_ZIP% -d %PATH_EXPORT%
                        del %PATH_ZIP%
                    """
                }
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -P distant'
            }
        }
    }
    post {
        always {
            bat """
                set /p TOKEN=<token.txt
                curl -H "Content-Type: application/json" -X POST -H "Authorization: Bearer %TOKEN%"  --data @"%PATH_CUCUMBER_FILE%" https://xray.cloud.getxray.app/api/v2/import/execution/cucumber
            """
            junit 'target/surefire-reports/*.xml'
            cucumber fileIncludePattern: 'target/cucumber.json'
            cleanWs()
        }
    }
}