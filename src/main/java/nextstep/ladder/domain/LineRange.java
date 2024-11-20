package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Objects;

public class LineRange {
    private int left;
    private int right;

    public LineRange(int left) {
        this.left = left;
        this.right = left + 1;
    }

    void swap(HashMap<Integer, Integer> map) {
        validContainIndex(map);
        swapValue(map);
    }

    private void swapValue(HashMap<Integer, Integer> map) {
        Integer leftValue = map.get(this.left);
        Integer rightValue = map.get(this.right);
        map.put(this.left, rightValue);
        map.put(this.right, leftValue);
    }

    private void validContainIndex(HashMap<Integer, Integer> map) {
        if (!map.containsKey(this.left) || !map.containsKey(this.right)) {
            throw new IllegalArgumentException("이동하려는 위치가 존재하지 않습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LineRange that = (LineRange) o;
        return left == that.left && right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
