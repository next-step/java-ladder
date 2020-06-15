package step2.domain;

import step2.util.RandomGenerator;

public class Point {
    private static final int FIRST_POSITION = 0;
    private static final int ONE = 1;

    private final int currentPosition;
    private final boolean leftLine;
    private final boolean rightLine;

    private Point(int currentPosition, boolean leftLine, boolean rightLine){
        this.currentPosition = currentPosition;
        this.leftLine = leftLine;
        this.rightLine = rightLine;
    }

    public static Point first(){
        return decidedRight(FIRST_POSITION, Boolean.FALSE);
    }

    public static Point drawVertical(int currentPosition, Point currentLine) {
        return decidedRight(currentPosition, currentLine.rightLine);
    }

    private static Point decidedRight(int currentPosition, boolean leftLine) {
        boolean decidedBoolean = RandomGenerator.generate();
        if (leftLine){
            decidedBoolean = false;
        }
        return new Point(currentPosition, leftLine, decidedBoolean);
    }

    public static Point last(Point ladderLine) {
        return decidedLast(ladderLine.currentPosition + ONE, ladderLine.left());
    }

    private static Point decidedLast(int currentPosition, Boolean leftLine) {
        return new Point(currentPosition, leftLine, Boolean.FALSE);
    }

    public boolean right(){
        return rightLine;
    }

    public  boolean left(){
        return leftLine;
    }

    public boolean isFirstLine(){
        return currentPosition == FIRST_POSITION;
    }

    public boolean isLastLine(int countOfperson){
        return currentPosition == countOfperson - ONE;
    }
}
