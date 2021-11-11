fun main(args: Array<String>) {

    val admin = Administrador("NombreAdmin", "ApellidoAdmin", "admin@ejemplo.com")

    val instructorVacio = Instructor("Sin asignar", "", "")
    val instructor1 = Instructor("NombreInstructor1", "ApellidoInstructor1","instructor1@ejemplo.com")
    val instructor2 = Instructor("NombreInstructor2", "ApellidoInstructor2","instructor2@ejemplo.com")
    val instructor3 = Instructor("NombreInstructor3", "ApellidoInstructor3","instructor3@ejemplo.com")

    val instructores = HashSet<Instructor>(listOf(instructorVacio, instructor1, instructor2, instructor3))

    val curso1 = Curso("Curso 1", instructorVacio)
    val curso2 = Curso("Curso 2", instructorVacio)
    val curso3 = Curso("Curso 3", instructorVacio)
    val curso4 = Curso("Curso 4", instructorVacio)
    val curso5 = Curso("Curso 5", instructorVacio)

    val cursos = HashSet<Curso>(listOf(curso1, curso2, curso3, curso4, curso5))

    curso1.instructor = instructor2
    curso2.instructor = instructor2
    curso3.instructor = instructor1
    curso5.instructor = instructor3


    instructor2.anyadirCurso(curso1)
    instructor2.anyadirCurso(curso2)
    instructor1.anyadirCurso(curso3)
    instructorVacio.anyadirCurso(curso4)
    instructor3.anyadirCurso(curso5)

    println("Asignación de instructor por curso")
    println("----------------------------------")

    for (curso in cursos) {
        println("El instructor del curso \"${curso.nombre}\" es \"${curso.listarInstructor().nombreCompleto}\"")
        curso.listarInstructor()
    }

    for (instructor in instructores) {
        println("\nCursos del instructor \"${instructor.nombreCompleto}\":")
        println("---------------------------------------------------------")
        val cursosPorInstructor = instructor.listarCursos()
        for (curso in cursosPorInstructor) {
            println(curso.nombre)
        }

    }

    val estudiante1 = Estudiante(
        "NombreEstudiante1",
        "ApellidoEstudiante1",
        "estudiante1@ejemplo.com",
    )

    val estudiante2 = Estudiante(
        "NombreEstudiante2",
        "ApellidoEstudiante2",
        "estudiante2@ejemplo.com",
    )

    val estudiante3 = Estudiante(
        "NombreEstudiante3",
        "ApellidoEstudiante3",
        "estudiante3@ejemplo.com",
    )

    println("\nEstudiantes inician sesión y gestionan cursos")
    println("---------------------------------------------")

    estudiante1.login()

    estudiante1.matricularEnCurso(curso1)
    estudiante1.matricularEnCurso(curso3)
    estudiante1.matricularEnCurso(curso4)

    estudiante2.login()

    estudiante2.matricularEnCurso(curso1)
    estudiante2.matricularEnCurso(curso3)

    estudiante1.logout()
    estudiante2.logout()

    estudiante3.login()
    estudiante3.matricularEnCurso(curso4)
    estudiante3.matricularEnCurso(curso5)

    estudiante3.logout()

    val estudiantes = HashSet<Estudiante>(listOf(estudiante1, estudiante2, estudiante3))

    for (estudiante in estudiantes) {
        println("\nCursos del estudiante \"${estudiante.nombreCompleto}\":")
        println("---------------------------------------------------------")
        val cursosDeEstudiante = estudiante.listarCursos()
        for (curso in cursosDeEstudiante) {
            println(curso.nombre)
        }
    }

    for (curso in cursos) {
        println("\nEstudiantes del curso \"${curso.nombre}\":")
        println("---------------------------------------------------------")
        val estudiantesPorCurso = curso.listarEstudiantes()
        for (estudiante in estudiantesPorCurso) {
            println(estudiante.nombreCompleto)
        }
    }

    for (instructor in instructores) {
        instructor.actualizarEstudiantes()

        println("\nEstudiantes del instructor \"${instructor.nombreCompleto}\":")
        println("---------------------------------------------------------")
        val estudiantesPorinstructor = instructor.listarEstudiantes()
        for (estudiante in estudiantesPorinstructor) {
            println(estudiante.nombreCompleto)
        }
    }

    println("\nAdministrador gestionando instructores")
    println("----------------------------------------")

    for (usuario in instructores) {
        admin.iniciarSesion(usuario)
        admin.cerrarSesion(usuario)
    }

    println("\nAdministrador gestionando estudiantes")
    println("---------------------------------------")
    for (usuario in estudiantes) {
        admin.iniciarSesion(usuario)
        admin.cerrarSesion(usuario)
    }

}