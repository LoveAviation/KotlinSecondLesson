data class Person(var name: String?, var phoneBook: HashSet<String?>, var emailBook: HashSet<String?>) {
    fun addPhone(phoneNum: String?){
        phoneBook.add(phoneNum)
    }
    fun addEmail(emailAd: String?){
        emailBook.add(emailAd)
    }

    fun getPB(): HashSet<String?>{
        return HashSet(phoneBook)
    }
    fun getEB(): HashSet<String?>{
        return HashSet(emailBook)
    }
    override fun toString(): String {
        if(name != null){
            return "Name: $name, \nPhone book: $phoneBook \nEmails: $emailBook"
        }else{
            return "Not initialized"
        }
    }
}