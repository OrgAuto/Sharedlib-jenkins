def call() {
    echo "Welcome "
    script{
            sh '''
                    git log -m -1 --name-status HEAD > '"${WORKSPACE}"/Logs/commit.log'
                    ls -l Logs/
            '''
        println("${WORKSPACE}")
        File f = new File('"${WORKSPACE}"/Logs/commit.log')
        f.readLines()
	    }

}
