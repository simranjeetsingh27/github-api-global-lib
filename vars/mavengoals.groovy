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
