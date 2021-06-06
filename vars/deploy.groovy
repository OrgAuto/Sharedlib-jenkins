#!/usr/bin/env groovy

def myData(String commitSha) {
    println("The changed files are : \n")
    def delta_files = sh(returnStdout: true, script: 'git log -m -1 --name-status --pretty=format: HEAD')
    println("${delta_files}")
    def repo_dir = sh(returnStdout: true, script: 'git rev-parse --show-toplevel', encoding: 'UTF-8').trim()
    String path = "${repo_dir}" + "/Logs"
    String my_cmd = 'ls -l ${path}'
    String my_cmd_response = sh(returnStdout: true, script: my_cmd, encoding: 'UTF-8')
    println(my_cmd_response)
    def git_name_only_cmd = "git log -m -1 --name-only --pretty=format: --diff-filter=M ${commitSha}"
    def response = sh(returnStdout: true, script: git_name_only_cmd)
    println("${response}")
    script {

        sh '''
            new_dir=`git rev-parse --show-toplevel`
            ls -l $new_dir
            '''
    }
}
