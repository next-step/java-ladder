package nextstep.ladder.domain.result;

import nextstep.ladder.common.Direction;

public class Point {
    private int index;

    public Point(int index) {
        this.index = index;
    }

    public void move(Direction direction) {
        index += direction.getValue();
    }

    public int getIndex() {
        return index;
    }
}
