#!/usr/bin/env groovy
def call() {
    println("Welcome ")
    def delta_files = sh(returnStdout: true, script: 'git log -m -1 --name-status --pretty=format: HEAD')
    println("${delta_files}")
    def repo_dir = sh(returnStdout: true, script: 'git rev-parse --show-toplevel').trim()
    println("${repo_dir}")
    def git_name_only_cmd = "git log -m -1 --name-only --pretty=format: --diff-filter=M HEAD"
    def response = sh(returnStdout: true, script: git_name_only_cmd)
    def arr = []
    arr.add("${response}")
    println(arr)

//    def dir = "${WORKSPACE}"
//    def commit_file = dir + "/Logs/commit.log"
//    File f = new File(commit_file)
//    ArrayList arr = new ArrayList()
//    for(i in f.readLines()){
//        arr.add(i)
//    }
//    println(arr)
//    f.delete()
}
