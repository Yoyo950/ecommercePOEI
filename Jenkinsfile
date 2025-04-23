pipeline {
    parameters {
            string(name: 'TEST_KEYS', defaultValue: '', description: 'The keys of the tests imported and executed')
            choice(name: 'BROWSER', choices: ['chrome', 'edge', 'firefox'], description: 'The browser used for the tests')
            booleanParam(name: 'IS_HEADLESS', defaultValue: false, description: 'Define if we run in headless')
            string(name: 'URL_GRID', defaultValue: '', description: 'Necessary URL for running the test on a distant machine. If empty, the driver is used locally.')
    }

    environment {
        PATH_CUCUMBER_FILE = 'target/cucumber.json'
        PATH_ZIP = "features.zip"
        PATH_EXPORT = "src/test/resources/features/distant"
        HL = '%IS_HEADLESS%'
        TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0ZW5hbnQiOiJiNmNhZGQwNS1lMzQxLTNmMTctYjU1Zi00OTM0MTI4MWQ4MmEiLCJhY2NvdW50SWQiOiI3MTIwMjA6MDMxYzNhY2QtNzIwZi00MDViLThmMzQtODRlZDBjZmQwNGU4IiwiaXNYZWEiOmZhbHNlLCJpYXQiOjE3NDU0MDA5NzgsImV4cCI6MTc0NTQ4NzM3OCwiYXVkIjoiNjIwNUZCQTA0QUI0NDE3RDhCOTYwRTk5RTU1RkNDMzUiLCJpc3MiOiJjb20ueHBhbmRpdC5wbHVnaW5zLnhyYXkiLCJzdWIiOiI2MjA1RkJBMDRBQjQ0MTdEOEI5NjBFOTlFNTVGQ0MzNSJ9.RNYDQiXrdLvzvBaXY1O1UBP4Kmx4SswsNGk4WmitibE"
    }
    agent any

    stages {
        stage('Init') {
            steps {
                script {
                    bat 'del "src\\main\\resources\\config.properties"'
                    writeFile (file: 'src/main/resources/config.properties', text: "browser = ${params.BROWSER}\nurl=http://www.automationpractice.pl/\nheadless = ${params.IS_HEADLESS}\nurlGrid = ${params.URL_GRID}\nemail=finalTestPOEI1@gmail.com\npassword=loislane\nname=Lois\nsurname=Lane\ntimeout=5")
                    bat """
                        curl -H "Content-Type: application/json" -X GET -H "Authorization: Bearer %TOKEN%" -o %PATH_ZIP% "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=%TEST_KEYS%"
                        mkdir %PATH_EXPORT%
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
                curl -H "Content-Type: application/json" -X POST -H "Authorization: Bearer %TOKEN%"  --data @"%PATH_CUCUMBER_FILE%" https://xray.cloud.getxray.app/api/v2/import/execution/cucumber
            """
            junit 'target/surefire-reports/*.xml'
            cucumber fileIncludePattern: 'target/cucumber.json'
            cleanWs()
        }
    }
}
