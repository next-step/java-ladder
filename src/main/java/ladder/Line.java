package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
}
