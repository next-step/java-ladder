package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;
    private static final List<Boolean> flagList = new ArrayList<>(Arrays.asList(true, false));

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line newLine(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(validPrePoint(createPoint(), points));
        }

        return new Line(points);
    }

    private static boolean validPrePoint(boolean point, List<Boolean> points) {
        if (point && points.size() > 0 && points.get(points.size() - 1)) {
            return false;
        }

        return point;
    }

    private static boolean createPoint() {
        Collections.shuffle(flagList);

        return flagList.get(0);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int size() {
        return points.size();
    }
}
