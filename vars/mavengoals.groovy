def clone(Map config = [:]) {
git branch: 'ninja', url: 'https://github.com/simranjeetsingh27/spring3hibernate.git'
}
def clean(){
  sh 'mvn clean'
}
def compile(){
  sh 'mvn compile'
}
def stabiltity(){
  sh 'mvn pmd:pmd'
}
def quality(){
  sh 'mvn checkstyle:checkstyle'
}
def report(){
recordIssues(tools: [checkStyle()])
publishCoverage adapters: [coberturaAdapter('')], sourceFileResolver: sourceFiles('NEVER_STORE')
}
