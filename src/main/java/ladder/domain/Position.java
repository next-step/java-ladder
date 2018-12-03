package ladder.domain;

public class Position {

    private static final int START_POINT = 0;
    private static final int DEFAULT_ONE = 1;
    private Integer position;

    private Position(Integer position) {
        this.position = position;
    }

    public static Position from(Integer position) {
        return new Position(position);
    }

    public Integer getPosition() {
        return position;
    }

    public void moveLeftPosition() {
        this.position --;
    }

    public void moveRightPosition() {
        this.position ++;
    }

    public int leftPosition() {
        return position - DEFAULT_ONE;
    }

    public int rightPosition() {
        return position;
    }

    public boolean isNotEndPosition(int countOfPoint) {
        return position < countOfPoint;
    }

    public Boolean isNotStartPosition() {
        return position > START_POINT;
    }

    public boolean isExistRightPoint(LadderLine line) {
        return line.isExistPoint(rightPosition());
    }

    public boolean isExistLeftPoint(LadderLine line) {
        return line.isExistPoint(leftPosition());
    }


    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

}
