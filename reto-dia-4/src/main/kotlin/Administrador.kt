class Administrador (
    nombre: String,
    apellidos: String,
    email: String
) : Usuario(
    nombre,
    apellidos,
    email
) {
    var isAdmin: Boolean = true

    fun iniciarSesion(usuario: Usuario) {
        println("Administrador \"$nombreCompleto\" ha iniciado la sesión del usuario \"${usuario.nombreCompleto}\"")
        usuario.login()
    }

    fun cerrarSesion(usuario: Usuario) {
        println("Administrador \"$nombreCompleto\" ha cerrado la sesión del usuario \"${usuario.nombreCompleto}\"")
        usuario.logout()
    }
}