data class Usuario(val nomeUser: String, var nomeMatri: String = "")

data class ConteudoEducacional(val nomeCE: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional> = emptyList()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario): String {
        inscritos.add(usuario)
        usuario.nomeMatri = this.nome
        return "Usuario ${usuario.nomeUser} matriculado no curso de ${nome}"
    }
}

fun main() {
    println("Quais os novos alunos do curso?")
    val novosAlunos = mutableListOf<Usuario>()
    for (i in 1..3) {  // Reduced to 3 for testing, change back to 10 as needed
        print("Nome do aluno ${i}: ")
        val nomeUser = readln()
        novosAlunos.add(Usuario(nomeUser))
    }

    println("Quais os conteudos educacionais do curso?")
    val conteudos = mutableListOf<ConteudoEducacional>()
    for (i in 1..3) {  // Reduced to 3 for testing, change back to 10 as needed
        print("Nome do conteudo ${i}: ")
        val nomeCE = readln()
        conteudos.add(ConteudoEducacional(nomeCE))
    }

    println("Qual o nome da formacao?")
    val nome = readln()
    val formacao = Formacao(nome, conteudos)

    // Matricular alunos individualmente
    for (aluno in novosAlunos) {
        println(formacao.matricular(aluno))
    }

    println("Inscritos no curso ${formacao.nome}:")
    formacao.inscritos.forEach { println("- ${it.nomeUser}") }
}