package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson, BooleanFunction booleanFunction) {
        boolean buf = false;

        for (int i = 0; i < countOfPerson; i++) {
            buf = booleanFunction.apply(buf);
            points.add(buf);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }
}