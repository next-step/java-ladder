package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {
    private static List<Boolean> flagList = new ArrayList<>(Arrays.asList(true, false));
    private List<Boolean> points = new ArrayList<>();

    public Line() {}

    private boolean validPrevPoint(boolean point) {
        if (point && points.size() > 0 && points.get(points.size() - 1)) {
            return false;
        }
        return point;
    }

    private boolean createPoint() {
        Collections.shuffle(flagList);
        return flagList.get(0);
    }

    public void add(boolean point) {
        points.add(validPrevPoint(point));
    }

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            add(validPrevPoint(createPoint()));
        }
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(this.points);
    }
}
