package ladder.domain;

import static ladder.domain.Direction.*;

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

    public boolean isFirst() {
        return position == START_POINT;
    }

    public boolean isLast(LadderLine line) {
        return position == line.pointCount();
    }

    public Direction checkDirection(LadderLine line){
        if(isFirst())
            return first(line.isExistRightPoint(position));

        if(isLast(line))
            return last(line.isExistLeftPoint(position));

        return of(line.isExistLeftPoint(position), line.isExistRightPoint(position));
    }

    public void move(Direction direction) {
        if(Direction.LEFT == direction)
            moveLeftPosition();
        if(Direction.RIGHT == direction)
            moveRightPosition();
    }

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }

}
