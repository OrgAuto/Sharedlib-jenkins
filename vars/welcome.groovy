def call() {
    echo "Welcome "
    script{
            sh '''
                    git log -m -1 --name-status HEAD
            '''
	    }
}
