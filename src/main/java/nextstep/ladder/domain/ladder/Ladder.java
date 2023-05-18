package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import nextstep.ladder.domain.user.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Points> rows;

    public Ladder(List<Points> rows) {
        this.rows = rows;
    }

    public static Ladder create(int rowSize, int pointSize) {
        return new Ladder(
                IntStream.range(0, rowSize)
                        .mapToObj(index -> Points.initialize(pointSize - 1, new RandomBooleanGenerator()))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public List<Points> getRows() {
        return rows;
    }

    public int getResult(int userLocation) {
        Position position = new Position(userLocation);
        while (position.movable(rows)) {
            position.move(rows);
        }
        return position.getX();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "rows=" + rows +
                '}';
    }
    
}
