package ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(Boolean.FALSE);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public boolean isValidate(List<Boolean> points) {
        return !points.get(0) || !points.get(1);
    }
}
