package ladder.domain;

public class Point {

    private boolean prevPoint;
    private boolean nextPoint;

    public Point(boolean prevPoint, boolean nextPoint) {
        validaionPoint(prevPoint, nextPoint);
        this.prevPoint = prevPoint;
        this.nextPoint = nextPoint;
    }

    private void validaionPoint(boolean prevPoint, boolean nextPoint) {
        if (prevPoint && nextPoint) {
            throw new IllegalArgumentException("사다리 선은 양쪽에 연결될 수 없습니다.");
        }
    }

    public boolean isPrevPoint() {
        return prevPoint;
    }

    public boolean isNextPoint() {
        return nextPoint;
    }
}
