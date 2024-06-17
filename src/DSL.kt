import com.google.gson.Gson
import java.io.File

class DSL {
    fun exportUsers(p: AllUsers){
        val gson = Gson()
        val json = gson.toJson(p.users)
        File("src/exported.json").writeText(json)
        println("List of users was exported in 'exported.json'")
    }
}