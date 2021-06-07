#!/usr/bin/env groovy
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.io.File;

def call() {
    println("Welcome ")
    String cmd_commit = "git rev-parse HEAD"
    String cmd_top_level = "git rev-parse --show-toplevel"

    String repo_dir = sh (returnStdout: true, script: cmd_top_level).trim()
    String current_commit_sha = sh(returnStdout: true, script: cmd_commit).trim()

    String cmd_modified = "git log -m -1 --name-only --pretty=format: --diff-filter=M ${current_commit_sha}"
    String cmd_added = "git log -m -1 --name-only --pretty=format: --diff-filter=A ${current_commit_sha}"
    String cmd_deleted = "git log -m -1 --name-only --pretty=format: --diff-filter=D ${current_commit_sha}"

    def modified_files = sh(returnStdout: true, script: cmd_modified).trim()
    def new_files = sh(returnStdout: true, script: cmd_added).trim()
    def deleted_files = sh(returnStdout: true, script: cmd_deleted).trim()

//    String LogsPath = new File("${repo_dir}", "/Logs").toString();
//    File f = new File(LogsPath.trim() + "commit.log")

    // Print Deleted Files in the current commit
    println("${deleted_files}".split().length + " Deleted Files \n")

    // Prepare list of added and modified files
    def delta_files = []
    for (file in "${modified_files}".split()){
        delta_files.add(file)
    }
    for (added in "${new_files}".split()){
        delta_files.add(added)
    }

    def deploy_scripts = []
    def base_files = []

    // Convert String to Path
    for (name in delta_files) {
        Path path = Paths.get("${name}")
        def fileName = path.getFileName()           // GET FILENAME WITHOUT PATH
        if (path.toString().contains("Logs")) {     // Get files matching path pattern
            deploy_scripts.add(path)
        }
        String myfile = fileName.toString()
        int index = myfile.lastIndexOf('.')
        if (index > 0) {
            String extension = myfile.substring(index + 1)
            println("File Extension is: \n" + extension)
            def myextension = "." + extension
            base_files.add(fileName[0]-"${myextension}")
            println("File basename is : " + fileName[0]-"${myextension}")
            println(fileName[0])
        }
    }
    println("Delta Files: \n" + delta_files)
    println("Basename of the delta Files: \n" + base_files)
    println("Deployable Scripts : \n" + deploy_scripts)
}
