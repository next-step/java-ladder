package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private final Map<Integer, Integer> position;

    Position(Map<Integer, Integer> position) {
        this.position = new HashMap<>(position);
    }

    void swap(int left, int right) {
        validContainsIndex(left, right);
        swapValue(left, right);
    }

    private void validContainsIndex(int left, int right) {
        if (!position.containsKey(left) || !position.containsKey(right)) {
            throw new IllegalArgumentException("이동하려는 위치가 존재하지 않습니다");
        }
    }

    private void swapValue(int left, int right) {
        Integer leftValue = position.get(left);
        Integer rightValue = position.get(right);
        position.put(left, rightValue);
        position.put(right, leftValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
