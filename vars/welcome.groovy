#!/usr/bin/env groovy


def call() {
    println("Welcome ")
    String cmd_modified = "git log -m -1 --name-only --pretty=format: --diff-filter=M HEAD"
    String cmd_added = "git log -m -1 --name-only --pretty=format: --diff-filter=A HEAD"
    String cmd_deleted = "git log -m -1 --name-only --pretty=format: --diff-filter=D HEAD"
    String cmd_top_level = "git rev-parse --show-toplevel"
    String cmd_commit = "git rev-parse HEAD"

    String repo_dir = sh (returnStdout: true, script: cmd_top_level)
    String current_commit_sha = sh(returnStdout: true, script: cmd_commit)
    String modified_files = sh(returnStdout: true, script: cmd_modified)
    String new_files = sh(returnStdout: true, script: cmd_added)
    String deleted_files = sh(returnStdout: true, script: cmd_deleted)

    def changed_scripts = new File("commit.log").write(modified_files)
    def lines = new File("commit.log").readLines()
    def result = []
    for (x in lines){
        result.add(x.split())
    }
    def scripts = []
    result.each { element ->
        {
            scripts.add(element)
        }
    }
    println(scripts)

}
