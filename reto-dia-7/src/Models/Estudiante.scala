package Models

class Estudiante(nombre: String,
                 apellidos: String,
                 email: String,
                 var cursos: Set[String],
                 var proyectos: Set[String]
                ) extends Usuario(nombre, apellidos, email)  {}
