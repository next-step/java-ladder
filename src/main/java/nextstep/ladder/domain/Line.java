package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line from(int countOfPerson) {
        return new Line(new ArrayList<>());
    }
}
