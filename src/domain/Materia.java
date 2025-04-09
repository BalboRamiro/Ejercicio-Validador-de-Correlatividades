package domain;

import java.util.HashSet;
import java.util.Set;

public class Materia {
    private Set<Materia> correlativas;

    // Constructor con correlativas
    public Materia(Set<Materia> correlativas) {
        this.correlativas = new HashSet<>(correlativas);
    }

    public Set<Materia> getCorrelativas() {
        return correlativas;
    }
}