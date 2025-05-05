package nextstep.ladder.domain.ladder;

import java.util.List;

import static nextstep.ladder.domain.generator.LineGenerator.assertValidLine;
import static nextstep.ladder.domain.generator.LineGenerator.generateLine;

public class Line {
    private final List<Boolean> line;

    public Line(int countOfPeople) {
        this(generateLine(countOfPeople));
    }

    public Line(Line other) {
        this(List.copyOf(other.line));
    }

    public Line(Boolean... values) {
        this(List.of(values));
    }

    public Line(List<Boolean> values) {
        assertValidLine(values);
        this.line = List.copyOf(values);
    }

    public int size() {
        return line.size();
    }

    public List<Boolean> values() {
        return List.copyOf(line);
    }

    public Index movePerson(Index index) {
        Direction direction = determineDirection(index);
        return direction.move(index);
    }
    private Direction determineDirection(Index index) {
        if (isMovableToLeft(index)) {
            return Direction.LEFT;
        }
        if (isMovableToRight(index)) {
            return Direction.RIGHT;
        }
        return Direction.PASS;
    }

    public boolean isMovableToLeft(Index index) {
        int targetIndex = index.value() - 1;
        return targetIndex >= 0 && line.get(targetIndex);
    }

    public boolean isMovableToRight(Index index) {
        int targetIndex = index.value();
        return targetIndex < line.size() && line.get(targetIndex);
    }
}
