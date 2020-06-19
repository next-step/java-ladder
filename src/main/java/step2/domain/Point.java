package step2.domain;

import step2.util.RandomGenerator;

public class Point {
    private static final int FIRST_POSITION = 0;
    private final static String EXIST_BAR_LINE = "|-----";
    private final static String NORMAL_LINE = "|     ";

    private final Position position;
    private final boolean leftLine;
    private final boolean rightLine;

    private Point(Position position, boolean leftLine, boolean rightLine){
        this.position = position;
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    public static Point of(int position, boolean leftLine, boolean rightLine){
        return of(new Position(position), leftLine, rightLine);
    }

    public static Point of(Position position, boolean leftLine, boolean rightLine){
        return new Point(position, leftLine, rightLine);
    }

    public static Point first(boolean rightLine){
        return of(FIRST_POSITION, false, rightLine);
    }

    public Point mid() {
        return of(position.increase(), rightLine, decidedMidValue());
    }

    private boolean decidedMidValue() {
        boolean decidedBoolean = RandomGenerator.generate();
        if (rightLine){
            decidedBoolean = false;
        }
        return decidedBoolean;
    }

    public Point last() {
        return of(position.increase(), leftLine, false);
    }

    public Position getPosition() {
        return position;
    }

    public boolean left(){
        return leftLine;
    }

    public boolean right() {
        return rightLine;
    }

    @Override
    public String toString() {
        if (rightLine){
            return EXIST_BAR_LINE;
        }
        return NORMAL_LINE;
    }


}
