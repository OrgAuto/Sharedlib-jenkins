class deployClass {
    static myData(commitSha) {
        println("The changed files are : \n")
        def delta_files = sh(returnStdout: true, script: 'git log -m -1 --name-status --pretty=format: \"${commitSha}\"')
        println("${delta_files}")
        def repo_dir = sh(returnStdout: true, script: 'git rev-parse --show-toplevel').trim()
        println("${repo_dir}")
        def git_name_only_cmd = "git log -m -1 --name-only --pretty=format: --diff-filter=M \"${commitSha}\""
        def response = sh(returnStdout: true, script: git_name_only_cmd)
        def arr = []
        arr.add("${response}")
        return arr
    }
    static void main(String[] args) {
        println(myData("HEAD"))
    }
}
