open class Usuario (
    var id: Long,
    var nombre: String,
    var apellidos: String,
    var email: String
    var sesionIniciada: boolean
    ) {

    fun login(){
        println("Usuario ha iniciado sesion")
        sesionIniciada = true
    }

    fun logout() {
        println("Usuario ha cerrado sesión")
        sesionIniciada = false
    }

}