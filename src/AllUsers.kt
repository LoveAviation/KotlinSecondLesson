data class AllUsers(var users: HashSet<Person>){
    fun save(p: Person){
        users.add(p)
    }

    fun find(s: String){
        for(p: Person in users){
            for(email: String? in p.emailBook){
                if(s == email){
                    println(p.toString())
                    break
                }
            }
            for(phone: String? in p.phoneBook){
                if(s == phone){
                    println(p.toString())
                    break
                }
            }
        }
    }

    fun show(name: String){
        for(p: Person in users){
            if(name == p.name){
                print(p.toString())
            }
        }
    }
    fun showAllUSers(){
        for(p: Person in users){
            println(p.toString())
        }
    }
}
