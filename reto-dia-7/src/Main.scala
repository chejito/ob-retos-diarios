import Models._

object Main {
  def main(args: Array[String]): Unit = {

    val estudiante1 = Estudiante("estudiante1", "passwordEstudiante1", "estudiante1@ejemplo.com",
      Set("Java", "Spring"), Set("proyectoBackendOfertas", "proyectoGithubApi", "proyectoRetosDiarios"))
    val estudiante2 = Estudiante(null, "passwordEstudiante2", "estudiante2@ejemplo.com",
      Set("JavaScript", "HTML/CSS", "React"), Set("proyectoFrontEndOfertas", "proyectoRetosDiarios"))
    val estudiante3 = Estudiante("estudiante3", "", "estudiante3@ejemplo.com",
      Set("JavaScript", "HTML/CSS", "React"), Set("proyectoFrontEndOfertas"))
    val estudiante4 = Estudiante("", null, "estudiante4@ejemplo.com",
      Set("JavaScript", "Java"), Set("proyectoRetosDiarios"))

    val invitado = Invitado("invitado1", "passwordInvitado1", "invitado1@ejemplo.com", 1800000)

    val administrador1 = Administrador("administrador1", "passwordAdministrador1", "administrador1@ejemplo.com", 1)
    val administrador2 = Administrador("administrador2", "passwordAdministrador2", "administrador2@ejemplo.com", 2)

    val usuarios = Set(estudiante1, estudiante2, estudiante3, estudiante4, invitado, administrador1, administrador2)

    usuarios.foreach {
      case Invitado(nombre, _, _, _) =>
        println(s"\nNombre: $nombre")
        println("No estás autorizado a entrar en esta lección")

      case Estudiante(nombre, password, _, _, _) =>
        println(s"\nNombre: $nombre - Password: $password")
        val errorCredenciales: String = "No tienes un nombre de usuario y/o password"
        nombre match {
          case null | "" => println(errorCredenciales)
          case _ => password match {
            case null | "" => println(errorCredenciales)
            case _ => println(s"Bienvenid@ a OpenVitae, $nombre")
          }
        }

      case Administrador(nombre, _, _, nivel) =>
        println(s"\nNombre: $nombre - Nivel: $nivel")
        nivel match {
        case x if x < 2 => println("Tu nivel es insuficiente")
        case _ => println("Tu nivel es el correcto")
      }
    }

  }

}
