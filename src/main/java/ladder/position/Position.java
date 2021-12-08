package ladder.position;

import java.util.HashMap;
import java.util.Map;

public class Position {
    private static final Map<Integer, Position> cache = new HashMap<>();

    private final int value;

    private Position(int value) {
        this.value = value;

        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
    }

    public static Position of(int value) {
        return generate(value);
    }

    public static Position generate(int value) {
        if (cache.containsKey(value)) {
            return cache.get(value);
        }

        Position position = new Position(value);
        cache.put(value, position);

        return position;
    }

    public int value() {
        return value;
    }
}
