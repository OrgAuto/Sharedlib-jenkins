def call() {
    echo "Welcome "
    script{
            sh '''
                    git log -m -1 --name-status HEAD > "${WORKSPACE}"/Logs/commit.log
                    ls -l Logs/
                    pwd
            '''
        println("${WORKSPACE}")
        def dir = "${WORKSPACE}"
        def commit_file = dir + "/Logs/commit.log"
        File f = new File(commit_file)
        println(f.path)
        println(f.readLines())
	    }

}
