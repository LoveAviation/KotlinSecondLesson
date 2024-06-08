sealed class Commands : Command {
    fun printInstruction(){
        println("List of commands:")
        println("help - shows this list")
        println("exit - stop the program")
        println("add <Name> phone <phoneNumber> - add a user with phone number(number need to start with '+'!)")
        println("add <Name> email <email> - add a user with email(email need to contain '@'!)")
    }
    class stop: Commands(){ // не добавил метод isValid, так как нет аргументов, которые нужно проверить
        var exit : Boolean = false
        override fun run(){
            exit = true
        }
    }
    class help: Commands(){ // не добавил метод isValid, так как нет аргументов, которые нужно проверить
        override fun run(){
            printInstruction()
        }
    }

    class addEmail(name : String?, email : String?): Commands(){
        val regex = Regex("[a-zA-Z]+@[a-zA-Z]+\\.[a-zA-Z]+")

        var name: String? = name
        var email: String? = email

        private fun isValid(): Boolean{
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

        private fun isValid(): Boolean{
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

    class show(u: User):Commands(){
        var user = u
        override fun run() {
            println(user.toString())
        }
    }

}