package ladder.domain;

import ladder.constant.Type;
import ladder.exception.InvalidCountOfPositionException;
import ladder.exception.NotFoundPositionException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Positions {

    public static final int MIN_COUNT_OF_POSITION = 2;
    private static final int EXCLUSION_POINT_VALUE = 1;
    private static final int EMPTY_VALUE = 0;

    private final List<Position> values;

    public Positions(List<Position> values) {
        if (values.size() < MIN_COUNT_OF_POSITION) {
            throw new InvalidCountOfPositionException();
        }
        this.values = values;
    }

    public static Positions createPlayers(String[] names) {
        return new Positions(convertToList(names, Type.UNFIXED));
    }

    public static Positions createResults(String[] names) {
        return new Positions(convertToList(names, Type.FIXED));
    }

    private static List<Position> convertToList(String[] names, Type type) {
        return IntStream.range(Index.MIN_VALUE, names.length)
                .mapToObj(index -> new Position(names.length - 1, index, names[index], type))
                .collect(Collectors.toList());
    }

    public int pointCount() {
        return values.size() - EXCLUSION_POINT_VALUE;
    }

    public List<Position> toList() {
        return Collections.unmodifiableList(values);
    }

    public boolean hasSameSize(Positions otherPositions) {
        return values.size() == otherPositions.values.size();
    }

    public int count() {
        return values.size();
    }

    public int maxNameSize() {
        return values.stream()
                .mapToInt(Position::nameSize)
                .max()
                .orElseThrow(RuntimeException::new);
    }

    public boolean containUnfixedPosition() {
        return values.stream()
                .filter(Position::isUnfixed)
                .count() > EMPTY_VALUE;
    }

    public Position value(Name name) {
        return values.stream()
                .filter(position -> position.hasSame(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundPositionException(name.toString()));
    }

    public Position value(Index index) {
        return values.stream()
                .filter(position -> position.hasSame(index))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions = (Positions) o;
        return Objects.equals(values, positions.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
