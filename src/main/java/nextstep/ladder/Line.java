package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(true);
        }
    }


    public List<Boolean> points() {
        return points;
    }
}
