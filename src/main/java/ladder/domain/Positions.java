package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Positions {

    private final List<Position> positions;

    public Positions(List<Position> positions) {
        this.positions = positions;
    }

    public static Positions createBasePositions(List<Integer> positions) {
        List<Position> basePositions = positions.stream()
                .map(Position::new)
                .collect(Collectors.toList());

        return new Positions(basePositions);
    }

    public void recordEndPosition(List<Position> endPositions) {
        this.positions.clear();
        this.positions.addAll(endPositions);
    }


    public Position getPosition(int index) {
        return this.positions.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions1 = (Positions) o;
        return Objects.equals(positions, positions1.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
