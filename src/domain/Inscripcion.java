package domain;

import java.util.Set;

public class Inscripcion {
    private Set<Materia> materiasInscriptas; // Materias solicitadas por el alumno.
    private Alumno alumno; // Alumno asignado a la inscripción.

    public Inscripcion(Alumno alumno, Set<Materia> materiasInscriptas) {
        this.alumno = alumno;
        this.materiasInscriptas = materiasInscriptas;
    }

    // Valida si todas las materias cumplen las correlatividades necesarias y esten aprobadas.
    public boolean aprobada() {
       return materiasInscriptas.stream().allMatch(materiaInscripta -> alumno.correlativasAprobadas(materiaInscripta));
    }
}