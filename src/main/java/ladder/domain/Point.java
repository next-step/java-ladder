package ladder.domain;

import ladder.domain.moveStrategy.Shift;

import java.util.List;

public class Point {

    private static final int FIRST_POSITION = 0;
    private static final  String EXIST_BAR_LINE = "|-----";
    private static final  String NORMAL_LINE = "|     ";

    private final Position position;
    private final Direction direction;

    private Point(Position position, Direction direction){
        this.position = position;
        this.direction = direction;
    }

    public static Point of(int position, boolean leftLine, boolean rightLine) {
        return new Point(Position.of(position), Direction.of(leftLine, rightLine));
    }

    public static Point first(Shift moveStrategy){
        return new Point(Position.of(FIRST_POSITION), Direction.decideRight(moveStrategy));
    }

    public Point mid() {
        return new Point(position.increase(), direction.next());
    }

    public Point last() {
        return new Point(position.increase(), direction.last());
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public int move(){
        return position.getPosition() + direction.move();
    }

    @Override
    public String toString() {
        if (direction.rightLine()){
            return EXIST_BAR_LINE;
        }
        return NORMAL_LINE;
    }
}
