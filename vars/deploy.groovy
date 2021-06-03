def myData(String commitSha) {
    println("The changed files are : \n")
    def response = ['git', 'log', '-1', "${commitSha}"].execute().text
    return response
}
