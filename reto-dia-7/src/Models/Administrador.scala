package Models

case class Administrador (
                           nombre: String,
                           password: String,
                           email: String,
                           var nivel: Int
                         ) extends Usuario(nombre, password, email){

}