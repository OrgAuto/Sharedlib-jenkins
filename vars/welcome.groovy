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

    def commit_file = repo_dir + "/" + "commit.log"
    File f = new File(commit_file)
    f.write(modified_files)
//    def scripts = []
//    for(line in f.readLines()){
//        scripts.add(line.split())
//    }
//    println(scripts)
}
