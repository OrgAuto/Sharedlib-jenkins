#!/usr/bin/env groovy
import java.lang.reflect.Array
import java.nio.file.Path;
import java.nio.file.Paths;


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
    println(deleted_files.split().length + " Deleted Files \n")

//    for (val in deleted_files.split()){
//        println(val)
//    }
//    println(modified_files)
//    println(new_files)
//    for (file in modified_files){
//        println("Modified: " + "${file}")
//    }
    for (added in new_files){
        println("Added: " + "${added}")
    }

//    f.write(modified_files)
//    f.append(", ")
//    f.append(new_files)
//    def arr = f.readLines()
//    println(arr[0])
//
//    for (i in arr) {
//        Path path = Paths.get(i)
//        println(path)
//    }

//    f.delete()
}
