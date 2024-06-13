interface Command {
    fun run()
    fun isValid(): Boolean
}