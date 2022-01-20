@Library("shared-library@main") _
pipeline{
    agent {label 'slave'}
    stages{
        
        stage("clone"){
            steps{
                script{
                    mavengoals.clone('ninja','https://github.com/simranjeetsingh27/spring3hibernate.git')
                }            
            }
        }
        stage("Code compile and Quality"){
            steps{
                script{
                mavengoals.compile()
                mavengoals.quality()
                }
            }
        }
        stage("cobertura"){
            steps{
                sh 'mvn cobertura:cobertura'
            }
        }
        stage("Report Generations"){
            steps{
                recordIssues(tools: [checkStyle()])
                
            }
        }
                stage("Cobertura report"){
            steps{
                cobertura autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', conditionalCoverageTargets: '70, 0, 0', failUnhealthy: false, failUnstable: false, lineCoverageTargets: '80, 0, 0', maxNumberOfBuilds: 0, methodCoverageTargets: '80, 0, 0', onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false
            }
              
        }
               stage("Clean"){
            steps{
                script{
                mavengoals.clean()
                }
            }
        }
    }
}
