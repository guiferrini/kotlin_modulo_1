fun main() {
    println("*** Inicio ***")

//    val conta = Conta()
//    conta.titular = "Gui"
//    conta.numero = 10
//    conta.saldo = 0.0
//
//    println(conta.titular)
//    println(conta.numero)
//    println(conta.saldo)
    val contaAlex = Conta("Alex", 1000)
    contaAlex.deposito(200.0)

    val contaFran = Conta("Fran", 1001)
    contaFran.deposito(300.0)

    println("Depositando na conta do ${contaAlex.titular}")
    contaAlex.deposito(10.0)
    println("Saldo na Conta: ${contaAlex.saldo}")
    println("-----")

    println("Depositando na conta do ${contaFran.titular}")
    contaFran.deposito(60.0)
    println("Saldo na Conta: ${contaFran.saldo}")
    println("-----")

    println("Sacando da conta do ${contaAlex.titular}")
    contaAlex.saca(20.0)
    println("Saldo na Conta: ${contaAlex.saldo}")
    println("-----")

    println("Sacando da conta do ${contaFran.titular}")
    contaFran.saca(400.0)
    println("Saldo na Conta: ${contaFran.saldo}")
    println("-----")

//    println("Transferindo da Conta ${contaAlex.titular} para Conta ${contaFran.titular}")
//    contaAlex.transfere(1000.0, contaFran)
//    println("Saldo Conta Alex: ${contaAlex.saldo}")
//    println("Saldo conta Fran: ${contaFran.saldo}")

    //Por retornar um Boolean o 'if' funciona/tem sentido
    if (contaAlex.transfere(10.0, contaFran)) {
        println("Transferencia efetuada com Sucesso")
    } else {
        println("Falha na transferencia")
    }
    println("Saldo Conta Alex: ${contaAlex.saldo}")
    println("Saldo conta Fran: ${contaFran.saldo}")

//    testalacos()
//     testaCondicaoSaldo(saldo)
}

class Conta(
        var titular: String,
        val numero: Int
) {  //1° letra maiúscula!
//    var titular = "" //var (vai ser alterado0, "" (tenho q iniciar a variável/valor padrao)
//    var numero = 0
    var saldo = 0.0
        private set //apenas nossa classe consegue ajustar o saldo, com Deposito() ou Saque()
//        set(valor){
//            field = valor
//        }
//        get(){return field}

//    constructor(titular: String, numero: Int){ //construtor secuindario, primario é o q está com o nome da classe
//        this.titular = titular
//        this.numero = numero
//    }

    init{
        println("Init - Executa alguma coisa durante a construção.\n")
    }

    fun deposito(valor: Double) {
        if(valor > 0) {
            this.saldo += valor // this. -> estou mexendo com algo do proprio objeto - deixo claro
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        } else {
            println("ERRO. Você não tem saldo suficiente para efetuar esse saque.")
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean { //quem chama a função é a conta de origem
        if (saldo >= valor) {
            saldo -= valor
            destino.deposito(valor)
            return true
        } else {
            println("ERRO. Você não tem saldo suficiente para efetuar a Transferencia.")
            return false
        }
    }
//    //ENCAPSULAMENTO
//    fun getSaldo(): Double { //Protege o 'saldo', apenas a conta pode alterálo, e n qq pto do codigo/qq um
//        return saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if(valor > 0){
//            saldo = valor
//        }
//    }
}

fun testalacos() {
    var i = 1
    while (i < 5) {
        val titular: String = "Gui"
        val numeroConta: Int = 10 + i // a conta n pretendo mudar, entao é 'val'
        var saldo: Double = 0.0 + i  // o saldo sim será laterado então é 'var'

        println("Conta #$i")
        println(" Titular $titular \n Número da Conta $numeroConta \n Saldo $saldo")
        println()
        i++
    }


//    for (i in 1..4) {
//        if(i == 3){
//            println("O '3' foi encontrado")
//            println()
////            break
//            continue
//        }
//
//        val titular: String = "Gui"
//        val numeroConta: Int = 10 + i // a conta n pretendo mudar, entao é 'val'
//        var saldo: Double = 0.0 + i  // o saldo sim será laterado então é 'var'
//
//        println("Conta #$i")
//        println(" Titular $titular \n Número da Conta $numeroConta \n Saldo $saldo")
//        println()
//    }
}

fun testaCondicaoSaldo(saldo: Double) {
    if (saldo > 0.0) {
        println("O Saldo da Conta é POSITIVA")
    } else if (saldo == 0.0) {
        println("O Saldo da Conta é NEUTRA")
    } else {
        println("O Saldo da Conta é NEGATIVA")
    }
//     when {
//         saldo > 0.0 -> println("O Saldo da Conta é POSITIVA")
//         saldo == 0.0 -> println("O Saldo da Conta é NEUTRA")
//         else -> println("O Saldo da Conta é NEGATIVA")
//     }
}