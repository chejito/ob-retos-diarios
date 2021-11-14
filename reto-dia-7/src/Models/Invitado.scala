package Models

case class Invitado(
                     nombre: String,
                     password: String,
                     email: String,
                     var limiteSesion: Int
                   ) extends Usuario(nombre, password, email)
