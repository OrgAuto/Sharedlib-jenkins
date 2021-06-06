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

    String root= new File(repo_dir)
    println("${root}")
    String full= new File(root,"/Logs")
//    println("${full}")
//    println("${root}${full}")
    println(full)
//    StringBuilder s = new StringBuilder()
//    println(root+full)
//    println(s)
    String path1 = "/Users/uprince/.jenkins/jobs/OrgAuto/jobs/demo-shared-lib/branches/main/workspace/";
    String path2 = "Logs";

    String joinedPath = new File(path1, path2).toString();
    println(joinedPath)
    println("/Users/uprince/.jenkins/jobs/OrgAuto/jobs/demo-shared-lib/branches/main/workspace/Logs")
}
