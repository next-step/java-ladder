package nextstep.ladder.domain.tobe;

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
