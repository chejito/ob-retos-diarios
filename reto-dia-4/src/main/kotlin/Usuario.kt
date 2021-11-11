open class Usuario (
    nombre: String,
    apellidos: String,
    open var email: String,

    ) {
    var sesionIniciada: Boolean = false
    var nombreCompleto: String = "$nombre $apellidos"

    open fun login() {
        println("Usuario \"$nombreCompleto\" ha iniciado sesion")
        sesionIniciada = true
    }

    open fun logout() {
        println("Usuario \"$nombreCompleto\" ha cerrado sesión")
        sesionIniciada = false
    }

}