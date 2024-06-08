//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Program started! -----------------") //для удобства
    var exit = Commands.stop()
    var reader = ComReader()
    while(!exit.exit){
        var command = reader.readCommand()
        if(command is Commands.stop){
            exit.run()
        }
        if(command is Command) {
            command.run()
        }
    }
}
