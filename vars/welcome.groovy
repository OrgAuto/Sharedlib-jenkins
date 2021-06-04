def call() {
    echo "Welcome "
    script{
            sh '''
                    git log -m -1 --name-status HEAD > "./Logs/commit.log"
                    ls -l
            '''
	    }
    File f = new File("Logs/commit.log")
    f.readLines()
}
