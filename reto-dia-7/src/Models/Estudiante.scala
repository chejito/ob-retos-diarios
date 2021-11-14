package Models

case class Estudiante(
                       nombre: String,
                       password: String,
                       email: String,
                       cursos: Set[String],
                       proyectos: Set[String]
                     ) extends Usuario(nombre, password, email)  {

}
