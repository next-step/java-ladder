package nextstep.ladder.domain;

public class Brace {
    private final boolean leftPoint;
    private final boolean rightPoint;

    public Brace(boolean leftPoint, boolean rightPoint) {
        validate(leftPoint, rightPoint);
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    private void validate(boolean leftPoint, boolean rightPoint) {
        twoPointsAttached(leftPoint, rightPoint);
    }

    private static void twoPointsAttached(boolean leftPoint, boolean rightPoint) {
        if(leftPoint && rightPoint) {
            throw new IllegalArgumentException("선이 나란히 2개가 존재할 수 없습니다.");
        }
    }

    public boolean isLeft() {
        return leftPoint && !rightPoint;
    }

    public boolean isRight() {
        return !leftPoint && rightPoint;
    }
}
