sealed class Commands : Command {
    fun printInstruction(){
        println("List of commands:")
        println("help - shows this list")
        println("instruction - show how to use the program")
        println("exit - stop the program")
        println("add <Name> phone <phoneNumber> - add a user with phone number(number need to start with '+'!)")
        println("add <Name> email <email> - add a user with email(email need to contain '@'!)")
        println("addPhone <PhoneNumber> - add a phone number to current")
        println("addEmail <Email> - add an email to current")
        println("save - save current user")
        println("export - export all users in prepared JSON file")
        println("show - show current user")
        println("show <Name> - showing user by name")
        println("find <PhoneNumber/Email> - showing user by phone number or email")
        println("show everyone - show all the users")
    }
    class stop: Commands(){
        var exit : Boolean = false
        override fun run(){
            exit = true
        }

        override fun isValid(): Boolean {
            return true
        }
    }
    class help: Commands(){
        override fun run(){
            printInstruction()
        }
        override fun isValid(): Boolean {
            return true
        }
    }

    class instruction:Commands(){
        override fun run(){
            println("1) add user with command - add <Name> phone/email <Phone/Email>")
            println("2) you can add an extra phone number or email - addPhone/addEmail")
            println("3) save the user - save")
            println("4) export user in JSON file - export")
            println("4) find this user by commands: find, show or sow everyone")
            println("*) use 'help' to see the list of commands")
            println("(write 'exit' to finish the program)")
        }
        override fun isValid(): Boolean {
            return true
        }
    }

    class addEmail(name : String?, email : String?): Commands(){
        val regex = Regex("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+")

        var name: String? = name
        var email: String? = email

        override fun isValid(): Boolean{
            return if(email != null) regex.matches(email!!) else false
        }
        override fun run(){
            if(isValid() && name != null){
                println("Added $name - Email: $email")
            }  else {
                println("Something went wrong")
                printInstruction()
            }
        }
    }
    class addPhone(name : String?, phone : String?): Commands(){
        val regex = Regex("\\++[0-9]+")

        var name: String? = name
        var phone: String? = phone

        override fun isValid(): Boolean{
            return if(phone != null) regex.matches(phone!!) else false
        }

        override fun run() {
            if(isValid() && name != null){
                println("Added $name - Phone: $phone")
            } else {
                println("Something went wrong")
                printInstruction()
            }
        }
    }

    class show(u: Person):Commands(){
        var user = u
        override fun run() {
            println(user.toString())
        }
        override fun isValid(): Boolean {
            return true
        }
    }
    class nothing:Commands(){
        override fun run() {
        }
        override fun isValid(): Boolean {
            return true
        }
    }

}