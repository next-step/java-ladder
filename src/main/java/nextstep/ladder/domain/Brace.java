package nextstep.ladder.domain;

import java.util.Random;

public class Brace {
    private final Point leftPoint;
    private final Point rightPoint;

    public Brace(Point leftPoint, Point rightPoint) {
        validate(leftPoint, rightPoint);
        this.leftPoint = leftPoint;
        this.rightPoint = rightPoint;
    }

    public void validate(Point leftPoint, Point rightPoint) {
        twoPointsAttached(leftPoint, rightPoint);
    }

    private static void twoPointsAttached(Point leftPoint, Point rightPoint) {
        if(leftPoint.isPoint() && rightPoint.isPoint()) {
            throw new IllegalArgumentException("선이 나란히 2개가 존재할 수 없습니다.");
        }
    }

    public boolean isLeft() {
        return leftPoint.isPoint() && !rightPoint.isPoint();
    }

    public boolean isRight() {
        return !leftPoint.isPoint() && rightPoint.isPoint();
    }

    public static Brace first() {
        return new Brace(new Point(false), new Point(new Random().nextBoolean()));
    }

    public Brace next() {
        if(this.rightPoint.isPoint()) {
            return new Brace(this.rightPoint, new Point(false));
        }

        return new Brace(this.leftPoint, new Point(new Random().nextBoolean()));
    }

    public Brace last() {
        return new Brace(this.rightPoint, new Point(false));
    }

    @Override
    public String toString() {
        return "Brace{" +
                "leftPoint=" + leftPoint +
                ", rightPoint=" + rightPoint +
                '}';
    }
}
