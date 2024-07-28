//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String, val email : String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var nivel : Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if( usuario !in inscritos){
            inscritos.add(usuario)
            println("${usuario.nome} está matriculado (a) na ${nome} .")
        }else {
            println("${usuario.nome} já esta matriculado (a) no curso")
        }

    }
}

fun main() {
    // criando conteùdos
    var conteudo1 = ConteudoEducacional("Introdução ao kotlin", 65)
    var conteudo2 = ConteudoEducacional(" Avançado com  kotlin", 80)

    // criando uma formação

    var formacao = Formacao("Formação com kotlin", nivel = Nivel.INTERMEDIARIO, conteudos = listOf(conteudo1,conteudo2))

    // criando usuario

    var usuario1 = Usuario("Jose Souza","jose.souza@yaa.com")
    var usuario2 = Usuario("Maria Sa","maria.sa@yaa.com")

    // matriculando usuario na formação

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario1) // tentando matricular duas vezes o mesmo usuario.

    // Imprimindo Lista de inscritos

    println("lista de inscrito na ${formacao.nome}")

    for (inscrito in formacao.inscritos){
        println("Nome: ${inscrito.nome}, Email: ${inscrito.email}")
    }

}