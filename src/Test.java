import domain.*;

import domain.Inscripcion;
import domain.Materia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class InscripcionTests {

    private Materia algoritmos;
    private Materia sistemasYorg;
    private Materia paradigmas;
    private Materia analisisDeSistemas;
    private Materia disenioDeSistemas;
    private Materia sintaxis;
    private Materia discreta;

    private Alumno pepe;

    @BeforeEach
    void setUp() {
        // Crear materias básicas
        algoritmos = new Materia(Set.of());
        sistemasYorg = new Materia(Set.of());
        discreta = new Materia(Set.of());

        // Crear materias con correlativas
        sintaxis = new Materia(Set.of(discreta));
        paradigmas = new Materia(Set.of(algoritmos));
        analisisDeSistemas = new Materia(Set.of(sistemasYorg));

        disenioDeSistemas = new Materia(Set.of(paradigmas, analisisDeSistemas));

        // Inicializar alumno con materias aprobadas
        Set<Materia> materiasAprobadas = Set.of(paradigmas, analisisDeSistemas, sistemasYorg, algoritmos);
        pepe = new Alumno("Pedro", materiasAprobadas);
    }

    @Test
    public void inscripcionValida() {
        // Caso: Materias inscriptas cumplen todas las correlativas
        Set<Materia> materiasInscribir = Set.of(disenioDeSistemas);
        Inscripcion inscripcion = new Inscripcion(pepe, materiasInscribir);

        Assertions.assertTrue(inscripcion.aprobada(), "La inscripción es válida.");
    }

    @Test
    public void inscripcionInvalida() {
        // Caso: Materias inscriptas no cumplen todas las correlativas (falta AM1 para AM2)
        Set<Materia> materiasInscribir = Set.of(sintaxis, disenioDeSistemas);
        Inscripcion inscripcion = new Inscripcion(pepe, materiasInscribir);

        Assertions.assertFalse(pepe.correlativasAprobadas(sintaxis), "La inscripción es inválida.");
    }

    @Test
    public void inscripcionSimple() {
        // Caso: Materias sin correlativas siempre deberían ser válidas
        Set<Materia> materiasInscribir = Set.of(algoritmos, discreta, sistemasYorg);
        Inscripcion inscripcion = new Inscripcion(pepe, materiasInscribir);

        Assertions.assertTrue(inscripcion.aprobada(), "La inscripción debería ser válida.");
    }
}