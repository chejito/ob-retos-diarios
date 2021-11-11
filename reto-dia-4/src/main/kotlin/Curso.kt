class Curso(var nombre: String, var instructor: Instructor) {

    private var estudiantes = HashSet<Estudiante>()

    fun matricularEstudiante(estudiante: Estudiante) {
        estudiantes.add(estudiante)
    }

    fun devolverNombresEstudiantes(): HashSet<String> {
        val nombres = HashSet<String>()
        for (estudiante in estudiantes) {
            nombres.add(estudiante.nombreCompleto)
        }
        return nombres
    }

    fun listarInstructor(): Instructor {
        return instructor
    }

    fun listarEstudiantes(): HashSet<Estudiante> {
        return estudiantes
    }

    override fun toString(): String {
        return "Curso(nombre='$nombre', instructor=${instructor.nombreCompleto}, estudiantes=${this.devolverNombresEstudiantes()})"
    }


}