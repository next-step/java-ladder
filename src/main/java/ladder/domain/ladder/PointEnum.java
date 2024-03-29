package ladder.domain.ladder;

public enum PointEnum {
    TRUE(true),
    FALSE(false);

    private final boolean point;

    PointEnum(boolean point) {
        this.point = point;
    }

    public boolean getPoint() {
        return point;
    }

    public static PointEnum createPoint(boolean point) {
        return point ? TRUE : FALSE;
    }

    public static PointEnum createRandomPoint() {
        return Math.random() > 0.5 ? TRUE : FALSE;
    }
}
