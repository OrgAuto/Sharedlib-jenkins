def call() {
    echo "Welcome "
    script{
            sh '''
                    git log -m -1 --name-status HEAD > "Logs/commit.log"
                    ls -l Logs/
                    echo "${WORKSPACE}"
            '''
        println("${WORKSPACE}")
//        File f = new File('Logs/commit.log')
//        f.readLines()
	    }

}
