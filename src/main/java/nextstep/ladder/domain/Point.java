package nextstep.ladder.domain;

public class Point {
    private final boolean leftConnected;
    private final boolean rightConnected;

    private Point(boolean leftConnected, boolean rightConnected) {
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
    }

    public static Point make(int index, int pointCount, StepFactory stepFactory) {
        if (index == 0) {
            return new Point(false, stepFactory.next());
        }
        if (index == pointCount - 1) {
            return new Point(stepFactory.previous(), false);
        }
        return new Point(stepFactory.previous(), stepFactory.next());
    }

    public int moving() {
        return DirectionEnum.getDirection(leftConnected, rightConnected).getValue();
    }

    public boolean isLeftConnected() {
        return leftConnected;
    }
}
