package org.local

class deploy {
    static myData(String commitSha) {
        return commitSha
//        println("The changed files are : \n")
//        def repo_dir = sh(returnStdout: true, script: 'git rev-parse --show-toplevel').trim()
//        println("${repo_dir}")
//        def git_name_only_cmd = "git log -m -1 --name-only --pretty=format: --diff-filter=M HEAD"
//        def response = sh(returnStdout: true, script: git_name_only_cmd)
//        println("${response}")
    }

    static myList(String commitSha) {
        return commitSha
//        def git_name_only_cmd = "git log -m -1 --name-only --pretty=format: --diff-filter=M HEAD"
//        def response = sh(returnStdout: true, script: git_name_only_cmd)
//        println("${response}")
    }
}
