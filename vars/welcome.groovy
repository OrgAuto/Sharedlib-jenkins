#!/usr/bin/env groovy


def call() {
    println("Welcome ")
    String cmd_commit = "git rev-parse HEAD"
    String cmd_top_level = "git rev-parse --show-toplevel"


    String repo_dir = sh (returnStdout: true, script: cmd_top_level).trim()
    String current_commit_sha = sh(returnStdout: true, script: cmd_commit).trim()

    String cmd_modified = "git log -m -1 --name-only --pretty=format: --diff-filter=M ${current_commit_sha}"
    String cmd_added = "git log -m -1 --name-only --pretty=format: --diff-filter=A ${current_commit_sha}"
    String cmd_deleted = "git log -m -1 --name-only --pretty=format: --diff-filter=D ${current_commit_sha}"

    String modified_files = sh(returnStdout: true, script: cmd_modified).trim()
    String new_files = sh(returnStdout: true, script: cmd_added).trim()
    String deleted_files = sh(returnStdout: true, script: cmd_deleted).trim()

    String LogsPath = new File("${repo_dir}", "/Logs").toString();
    println(LogsPath)
    File f = new File(LogsPath.trim() + "commit.log")
    f.write(modified_files)
    f.append(new_files)
    println(f.readLines())
}
