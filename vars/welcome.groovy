#!/usr/bin/env groovy
def call() {
    echo "Welcome "
//    script{
//            sh '''
//              git log -m -1 --name-status --pretty=format: HEAD > "${WORKSPACE}"/Logs/commit.log
//            '''
//        }
    def git_cmd = 'git log -m -1 --name-status --pretty=format: HEAD'
    def delta_files = sh(returnStdout: true, script: git_cmd).trim()
    println(delta_files.split())
    def repo_dir = sh(returnStdout: true, script: 'git rev-parse --show-toplevel').trim()
    println("${repo_dir}")
    def dir = "${WORKSPACE}"
    def commit_file = dir + "/Logs/commit.log"
    File f = new File(commit_file)
    ArrayList arr = new ArrayList()
    for(i in f.readLines()){
        arr.add(i)
    }
    println(arr)
    f.delete()
}
