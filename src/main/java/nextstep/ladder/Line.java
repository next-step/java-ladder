package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>(countOfPerson - 1);
        for (int j = 0; j < countOfPerson - 1; j++) {
            points.add(false);
        }
    }

    public int size() {
        return points.size();
    }
}
