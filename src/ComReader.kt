class ComReader {
    var saver = AllUsers(hashSetOf())
    val dsl = DSL()
    var user = Person(null,  hashSetOf() , hashSetOf())
    fun readCommand(): Commands{
        print("Write command: ")
        val com : String? = readlnOrNull()
        when(com?.trim()){
            "help" -> return Commands.help()
            "exit" -> return Commands.stop()
            "show" -> return Commands.show(user)
            "instruction" -> return Commands.instruction()
            "save" -> {
                if(user.name != null){
                    saver.save(Person(user.name, user.getPB(), user.getEB()))
                    println("User is saved!")
                }else{
                    println("Cant be saved")
                }
                return Commands.nothing()
            }
            "show everyone" -> {
                if(saver.users.size == 0){
                    println("Nobody is in list!")
                }else {
                    saver.showAllUSers()
                }
                return Commands.nothing()
            }
            "export" -> {
                if(saver.users.size == 0){
                    println("Nobody is in list!")
                }else {
                    dsl.exportUsers(saver)
                }
                return Commands.nothing()
            }
        }
        if(com?.trim()?.substringBefore( ' ') == "add"){
            val name = com.trim().substringAfter(' ').substringBefore(' ')
            val smth = com.trim().substringAfter(' ').substringAfter(' ').substringAfter(' ')
            val key : String = com.trim().substringAfter(' ').substringAfter(' ').substringBefore(' ')
            if(key == "phone" && isValid(smth)) {
                user.emailBook.clear()
                user.phoneBook.clear()
                user.name = null

                user.name = name
                user.addPhone(smth)
                return Commands.addPhone(name, smth)
            }else if(key == "email" && isValid(smth)){
                user.emailBook.clear()
                user.phoneBook.clear()
                user.name = null

                user.name = name
                user.addEmail(smth)
                return Commands.addEmail(name, smth)
            }
            else
                return Commands.addPhone(name,null)
        }else if(com?.trim()?.substringBefore( ' ') == "addPhone"){
            if(isValid(com.trim().substringAfter(' '))) {
                user.addPhone(com.trim().substringAfter(' '))
                println("Added phone for user - ${user.name}")
            }else{
                println("Something went wrong")
            }
            return Commands.nothing()
        }else if(com?.trim()?.substringBefore( ' ') == "addEmail"){
            if(isValid(com.trim().substringAfter(' '))) {
                user.addEmail(com.trim().substringAfter(' '))
                println("Added email for user - ${user.name}")
            }else{
                println("Something went wrong")
            }
            return Commands.nothing()
        }else if(com?.trim()?.substringBefore( ' ') == "show"){
            saver.show(com.trim().substringAfter(' '))
            return Commands.nothing()
        }else if(com?.trim()?.substringBefore( ' ') == "find"){
            saver.find(com.trim().substringAfter(' '))
            return Commands.nothing()
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