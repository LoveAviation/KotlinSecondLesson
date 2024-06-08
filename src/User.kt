data class User(var name: String?, var phone: String?, var email: String?) {

    override fun toString(): String {
        if(name != null){
            if(phone != null){
                return "Name: $name, Phone number: $phone"
            }else if(email != null){
                return "Name: $name, Email: $email"
            }else{
                return "Error in initialization"
            }
        }else{
            return "Not initialized"
        }
    }
}