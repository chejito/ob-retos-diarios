class Estudiante (
    nombre: String,
    apellidos: String,
    email: String
    ) : Usuario(
    nombre,
    apellidos,
    email
) {
    private var cursos = HashSet<Curso>()
    private var ejerciciosEntregados = HashSet<String>()


    // Sobreescribimos los métodos login() y logout() para que reflejen
    // que es un Estudiante quien realiza la acción
    override fun login() {
        println("Estudiante \"$nombreCompleto\" ha iniciado sesion")
        sesionIniciada = true
    }

    override fun logout() {
        println("Estudiante \"$nombreCompleto\" ha cerrado sesión")
        sesionIniciada = false
    }

    // Método que matricula a un Estudiante en un Curso,
    // añadiendo el curso al ArrayList de cursos y
    // el Estudiante al ArrayList de Alumnos en el Curso
    fun matricularEnCurso(curso: Curso) {
        cursos.add(curso)
        curso.matricularEstudiante(this)
        println("\nEstudiante \"$nombreCompleto\" se ha matriculado en \"${curso.nombre}\"")
    }

    // Método que permite a un Estudiante entregar un ejercicio
    fun realizarEntrega(ejercicio: String) {
        ejerciciosEntregados.add(ejercicio)
        println("\nEstudiante \"$nombreCompleto\" ha entregado el ejercicio \"$ejercicio\"")
    }

    fun listarCursos(): HashSet<Curso>{
        return cursos
    }

}