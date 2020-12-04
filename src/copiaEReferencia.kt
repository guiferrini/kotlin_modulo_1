fun main(){

    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX") //numeroX 10
    println("numeroY $numeroY") // numeroY 11

    val contaGui = Conta("Gui", 1022)
//    contaGui.titular = "Gui"
    var contaSu = contaGui //ContaSu agora aponta p 'Conta()', instanciado por contaGui, ambos terao o msm valor
//    contaSu.titular = "Su"
//    contaGui.titular = "João"

    println("titular conta Gui: ${contaGui.titular}") //titula da conta Su
    println("titular conta Su: ${contaSu.titular}") //titular ca conta Su

    val contaJoao = Conta("Jãoa", 1030)
    contaJoao.titular = "João"
    var contaMaria = Conta("Maria", 1040)
    contaMaria.titular = "Maria"
    contaJoao.titular = "João"

    println("titular conta joao: ${contaJoao.titular}") //titula da conta joao
    println("titular conta maria: ${contaMaria.titular}") //titular ca conta Maria

    println(contaJoao)
    println(contaMaria)
}