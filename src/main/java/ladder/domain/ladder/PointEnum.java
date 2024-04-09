package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public enum PointEnum {
    TRUE(true),
    FALSE(false);

    private final boolean point;

    PointEnum(boolean point) {
        this.point = point;
    }

    public static List<PointEnum> createRandomPoints(int countOfPerson) {
        List<PointEnum> points = new ArrayList<>();
        points.add(PointEnum.createRandomPoint());
        for (int i = 1; i < countOfPerson - 1; i++) {
            points.add(PointEnum.createRandomPoint());
        }
        return points;
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

    public static Boolean isTrue(PointEnum point) {
        return point.equals(TRUE);

    }
}
