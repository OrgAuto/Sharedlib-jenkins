#!/usr/bin/env groovy
import java.nio.file.Path
import java.nio.file.Paths

def GetCommit() {
    String cmd_commit = "git rev-parse HEAD"
    String current_commit_sha = sh(returnStdout: true, script: cmd_commit).trim()
    return current_commit_sha
}

def GetCRepoDir() {
    String cmd_top_level = "git rev-parse --show-toplevel"
    String repo_dir = sh(returnStdout: true, script: cmd_top_level).trim()
    return repo_dir
}

def GetDeltaFiles(commit_id) {
    String cmd_modified = "git log -m -1 --name-only --pretty=format: --diff-filter=M ${commit_id}"
    String cmd_added = "git log -m -1 --name-only --pretty=format: --diff-filter=A ${commit_id}"
    String cmd_deleted = "git log -m -1 --name-only --pretty=format: --diff-filter=D ${commit_id}"

    def modified_files = sh(returnStdout: true, script: cmd_modified).trim()
    def new_files = sh(returnStdout: true, script: cmd_added).trim()
    def deleted_files = sh(returnStdout: true, script: cmd_deleted).trim()

    def delta_files = []
    for (file in "${modified_files}".split()){
        delta_files.add(file)
    }
    for (added in "${new_files}".split()){
        delta_files.add(added)
    }
    return delta_files
}
def GetDeployScripts(DeltaScriptsList) {
    def deploy_scripts = []
    for (name in DeltaScriptsList) {
        Path path = Paths.get("${name}")
        if (path.toString().contains("Logs")) {
            // Get files matching path pattern
            deploy_scripts.add(path)
        }

    }
    return deploy_scripts
}

def GetExtension(FilePath) {
    def FileName = FilePath.getFileName()           // GET FILENAME WITHOUT PATH
    String my_file = FileName.toString()
//    int index = my_file.lastIndexOf('.')
//    if (index > 0) {
//        String extension = my_file.substring(index + 1)
//        println("File Extension is: \n" + extension)
//    def my_extension = "." + extension
    def my_extension = my_file.split("\\.")[1]
    return "." + my_extension
//    }
}

def GetBaseName(FilePath, extension) {
    def FileName = FilePath.getFileName()
    def base_file = "${FileName}"-"${extension}"
    return base_file
}





