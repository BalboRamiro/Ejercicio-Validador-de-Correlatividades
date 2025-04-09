package domain;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
    private Set<Materia> materiasAprobadas; // Materias aprobadas por el alumno.
    private String apellido; // Apellido del alumno.

    public Alumno(String apellido, Set<Materia> materiasAprobadas) {
        this.apellido = apellido;
        this.materiasAprobadas = new HashSet<>(materiasAprobadas);
    }

    // Verifica que la materia inscripta este aproabada y que las correlativas tambien
    public boolean correlativasAprobadas(Materia materiaInscripta) {
        return materiasAprobadas.containsAll(materiaInscripta.getCorrelativas());
    }
}