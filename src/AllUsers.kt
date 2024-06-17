data class AllUsers(var users: HashSet<Person>){
    fun save(p: Person){
        users.add(p)
    }

    fun find(s: String){
        var isFinded = false
        for(p: Person in users){
            for(email: String? in p.emailBook){
                if(s == email){
                    println(p.toString())
                    isFinded = true
                    break
                }
            }
            for(phone: String? in p.phoneBook){
                if(s == phone){
                    println(p.toString())
                    isFinded = true
                    break
                }
            }
        }
        if(!isFinded){
            println("Nobody is found")
        }
    }

    fun show(name: String){
        var isFinded = false
        for(p: Person in users){
            if(name == p.name){
                isFinded = true
                print(p.toString())
            }
        }
        if(!isFinded){
            println("Nobody is found")
        }
    }
    fun showAllUSers(){
        for(p: Person in users){
            println(p.toString())
        }
    }

    override fun toString(): String {
        var s = ""
        for(p:Person in users){
            s += p.toString() + " "
        }
        return s
    }
}
