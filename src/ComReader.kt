class ComReader {
    var user = User(null, null,null)
    fun readCommand(): Commands{
        print("Write command: ")
        val com : String? = readlnOrNull()
        when(com?.trim()){
            "help" -> return Commands.help()
            "exit" -> return Commands.stop()
            "show" -> return Commands.show(user)
        }
        if(com?.trim()?.substringBefore( ' ') == "add"){
            val name = com.trim().substringAfter(' ').substringBefore(' ')
            val smth = com.trim().substringAfter(' ').substringAfter(' ').substringAfter(' ')
            val key : String = com.trim().substringAfter(' ').substringAfter(' ').substringBefore(' ')
            if(key == "phone" && isValid(smth)) {
                user.name = name
                user.phone = smth
                user.email = null
                return Commands.addPhone(name, smth)
            }else if(key == "email" && isValid(smth)){
                user.name = name
                user.email = smth
                user.phone = null
                return Commands.addEmail(name, smth)
            }
            else
                return Commands.addPhone(name,null)
        }
        else{
            println("Something went wrong, check the list of commands!")
            return Commands.help()
        }
    }

    fun isValid(s :String): Boolean{
        val regex1 = Regex("\\++[0-9]+")
        val regex2 = Regex("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+")
        return if(regex1.matches(s)||regex2.matches(s)) true else false
    }
}