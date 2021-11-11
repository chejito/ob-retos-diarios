class Instructor(
    nombre: String,
    apellidos: String,
    email: String
) : Usuario(
    nombre,
    apellidos,
    email
){

    private var cursos = HashSet<Curso>()
    private var estudiantes = HashSet<Estudiante>()

    fun anyadirEstudiante(estudiante : Estudiante) {
        estudiantes.add(estudiante)
    }

    fun anyadirCurso(curso: Curso) {
        cursos.add(curso)
        for (estudiante in curso.listarEstudiantes()) {
            anyadirEstudiante(estudiante)
        }
    }

    fun actualizarEstudiantes() {
        for (curso in cursos) {
            for (estudiante in curso.listarEstudiantes()) {
                anyadirEstudiante(estudiante)
            }
        }
    }

    fun listarCursos(): HashSet<Curso> {
        return cursos
    }

    fun listarEstudiantes(): HashSet<Estudiante> {
        return estudiantes
    }


    fun corregirEjercicio(ejercicio: String) {
        println("Instructor \"$nombreCompleto\" ha corregido el ejercicio \"$ejercicio\"")
    }
}