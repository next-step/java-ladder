package nextstep.ladder.domain;

import nextstep.ladder.dto.PointDto;

public class Point {
    private boolean left, right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public boolean movableRight() {
        return right;
    }

    public boolean movableLeft() {
        return left;
    }

    public int nextX(int x) {
        if (right) {
            return x + 1;
        }
        if (left) {
            return x - 1;
        }
        return x;
    }

    public PointDto toDto() {
        return new PointDto(left, right);
    }

}
