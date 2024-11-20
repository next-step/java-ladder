package nextstep.ladder.domain;

import java.util.HashMap;

public class PointIndex {
    private int left;
    private int right;

    public PointIndex(int left) {
        this.left = left;
        this.right = left + 1;
    }

    void swap(HashMap<Integer, Integer> map) {
        Integer leftValue = map.get(this.left);
        Integer rightValue = map.get(this.right);
        map.put(this.left, rightValue);
        map.put(this.right, leftValue);
    }
}
