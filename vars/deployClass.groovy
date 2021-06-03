class deployClass {
    static myData(commitSha) {
        println("The changed files are : \n")
        def cmd = 'git log -m -1 ' + commitSha
        def response = cmd.execute().text
        return response
    }
//    static void main(String[] args) {
//        println(myData("HEAD"))
//    }
}
