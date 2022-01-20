def clone(Map config = [:]) {
git branch: "$(config.branch)", url: "$(config.url)"
  git clone ${config.url}
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
