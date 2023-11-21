package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Bridges {

    private List<Boolean> bridges;

    public Bridges(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    public boolean isMovable(int position) {
        return this.bridges.get(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridges bridges1 = (Bridges) o;
        return Objects.equals(bridges, bridges1.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridges);
    }
}
