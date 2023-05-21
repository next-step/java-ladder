package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.generator.RandomBooleanGenerator;
import nextstep.ladder.domain.user.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder create(int rowSize, int pointSize) {
        return new Ladder(
                IntStream.range(0, rowSize)
                        .mapToObj(index -> Row.initialize(pointSize, new RandomBooleanGenerator()))
                        .collect(Collectors.toUnmodifiableList()));
    }

    public List<Row> getRows() {
        return rows;
    }

    public Position getLeaf(int userLocation) {
        Position userPosition = new Position(userLocation);
        for (Row row : rows) {
            int movePoint = row.getMovePoint(userPosition.getCurrentPosition());
            userPosition = userPosition.move(movePoint);
        }
        return userPosition;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "rows=" + rows +
                '}';
    }

}
