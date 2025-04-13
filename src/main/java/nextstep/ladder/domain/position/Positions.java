package nextstep.ladder.domain.position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Positions {
    private List<Position> value;

    public Positions() {
        this.value = new ArrayList<>();
    }

    public Positions(List<Integer> positions) {
        this.value = positions.stream().map(Position::new).collect(Collectors.toList());
    }

    public void add(Position position) {
        value.add(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions = (Positions) o;
        return Objects.equals(value, positions.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Positions{" +
            "value=" + value +
            '}';
    }
}
