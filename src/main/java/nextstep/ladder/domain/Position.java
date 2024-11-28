package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Position {

    private final List<Integer> position;


    Position(List<Integer> position) {
        this.position = new ArrayList<>(position);
    }

    void swap(int left, int right) {
        validContainsIndex(left);
        validContainsIndex(right);
        swapValue(left, right);
    }

    private void validContainsIndex(int index) {
        if (lastIndex() < index) {
            throw new IllegalArgumentException("이동하려는 위치가 존재하지 않습니다");
        }
    }

    private int lastIndex() {
        return this.position.size() - 1;
    }

    private void swapValue(int left, int right) {
        Integer leftValue = position.get(left);
        Integer rightValue = position.get(right);
        position.set(left, rightValue);
        position.set(right, leftValue);
    }

    public Map<String, String> match(final List<String> names, final List<String> results) {
        HashMap<String, String> result = new HashMap<>();
        for (int i = 0; i < position.size(); i++) {
            result.put(name(names, i), ladderResult(results, i));
        }
        return result;
    }

    private static String name(List<String> names, int i) {
        return names.get(i);
    }

    private String ladderResult(List<String> results, int i) {
        Integer resultIndex = this.position.get(i);
        return results.get(resultIndex);
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
