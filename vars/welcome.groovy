#!/usr/bin/env groovy
def call() {
    echo "Welcome "
    script{
            sh '''
              git log -m -1 --name-status --pretty=format: HEAD > "${WORKSPACE}"/Logs/commit.log
            '''
        }
    String repo_dir = sh 'git rev-parse --show-toplevel'
    println(repo_dir)
    def dir = "${WORKSPACE}"
    def commit_file = dir + "/Logs/commit.log"
    File f = new File(commit_file)
    println(f.path)
    ArrayList arr = new ArrayList()
    for(i in f.readLines()){
        arr.add(i)
    }
    println(arr)
    f.delete()
}
