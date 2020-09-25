package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Pipes {

    private List<Pipe> pipes;

    public Pipes(List<Pipe> pipes) {
        this.pipes = pipes;
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pipes pipes1 = (Pipes) o;
        return pipes.equals(pipes1.pipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pipes);
    }
}
