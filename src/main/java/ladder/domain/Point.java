package ladder.domain;

import ladder.domain.line.Line;

public class Point {

    private int index;

    public Point(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void move(Line line) {
        if (line.isMovementAvailable(index)) {
            index--;
            return;
        }

        if (line.isMovementAvailable(index + 1)) {
            index++;
            return;
        }
    }

}
