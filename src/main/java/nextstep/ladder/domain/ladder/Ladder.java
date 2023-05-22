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

    public Position leafPosition(int userLocation) {
        Position userPosition = new Position(userLocation);
        for (Row row : rows) {
            int movePoint = row.movePoint(userPosition.getCurrentPosition());
            userPosition = userPosition.move(movePoint);
        }
        return userPosition;
    }

    @Override
    public String toString() {
        return rows.stream()
                .map(Row::toString)
                .collect(Collectors.joining("\n"));
    }

}
