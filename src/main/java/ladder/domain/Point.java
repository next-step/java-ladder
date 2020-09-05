package ladder.domain;

public class Point {

    private boolean prevPoint;
    private boolean nextPoint;

    public Point(boolean prevPoint, boolean nextPoint) {
        this.prevPoint = prevPoint;
        this.nextPoint = nextPoint;
    }

    public boolean isPrevPoint() {
        return prevPoint;
    }

    public boolean isNextPoint() {
        return nextPoint;
    }
}
