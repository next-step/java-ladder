package nextstep.ladder2.domain.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Position {

    private int value;
    private final int max;

    private Position(int value, int max) {
        if (value < 0 || value >= max) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다: v=" + value + ", max=" + max);
        }
        
        this.value = value;
        this.max = max;
    }
    
    public static Position of(int value, int max) {
        return new Position(value, max);
    }
    
    public static List<Position> listOf(int max, int... values) {
        return Arrays.stream(values)
                .mapToObj(value -> new Position(value, max))
                .collect(Collectors.toList());
    }
    
    public static List<Position> range(int start, int end, int max) {
        return IntStream.range(start, end)
                .mapToObj(value -> new Position(value, max))
                .collect(Collectors.toList());
    }

    public void moveBy(Direction direction) {
        int target = value + direction.getValue();
        validatePosition(target);

        value = target;
    }

    private void validatePosition(int value) {
        if (value < 0 || value >= max) {
            throw new IllegalArgumentException("유효하지 않은 위치입니다: v=" + value + ", max=" + max);
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value && max == position.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, max);
    }
}
