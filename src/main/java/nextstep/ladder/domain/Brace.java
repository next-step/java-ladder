package nextstep.ladder.domain;

public class Brace {
    private final Point point;

    public Brace(Point point) {
        validate(point);
        this.point = point;
    }

    private static void checkPointIsNull(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Point는 빈 값이면 안됩니다.");
        }
    }

    public static Brace first() {
        return new Brace(Point.first());
    }

    public void validate(Point point) {
        checkPointIsNull(point);
    }

    public boolean isLeft() {
        return point.isLeft() && !point.isRight();
    }

    public boolean isRight() {
        return !point.isLeft() && point.isRight();
    }

    public Brace next() {
        if (this.point.isRight()) {
            return new Brace(Point.left());
        }

        return new Brace(point.next());
    }

    public Brace last() {
        return new Brace(point.last());
    }

    @Override
    public String toString() {
        return "Brace{" +
                "point=" + point +
                '}';
    }
}
