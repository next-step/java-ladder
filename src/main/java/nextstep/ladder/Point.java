package nextstep.ladder;

public class Point {
    private final int MAX_INDEX;
    private int leftIndex;
    private int rightIndex;
    private Position position;
    public Point(Position position, int MAX_INDEX) {
        this.position = position;
        this.MAX_INDEX = MAX_INDEX;
        setIndex(position);
    }

    private void setIndex(Position position) {
        this.leftIndex = position.value() - 1;
        this.rightIndex = position.value();
        checkSide();
    }

    public int left() {
        return this.leftIndex;
    }

    public int right() {
        return this.rightIndex;
    }

    public void moveRight(){
        this.leftIndex++;
        this.rightIndex++;
        checkSide();
    }

    public void moveLeft(){
        this.leftIndex--;
        this.rightIndex--;
        checkSide();
    }

    public void checkSide() {
        if (position.value() == 0) {
            this.leftIndex = Integer.MIN_VALUE;
        } else if (position.value() == MAX_INDEX) {
            this.rightIndex = Integer.MAX_VALUE;
        }
    }

    public int position() {
        return this.position.value();
    }
}
