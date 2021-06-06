#!/usr/bin/env groovy
import java.nio.file.Paths

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

    def changed_script = Paths.get(repo_dir, "/Logs/commit.log")
    println(changed_script)
    sh '''
            ls -l ${changed_script}
        '''


//    def scripts = []
//    for(line in f.readLines()){
//        scripts.add(line.split())
//    }
//    println(scripts)
}
