package Models

class Administrador (nombre: String,
                     apellidos: String,
                     email: String,
                     var nivel: Int) extends Usuario(nombre, apellidos, email){}