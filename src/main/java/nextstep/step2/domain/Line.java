package nextstep.step2;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(final int countOfPerson) {
        this.points = new ArrayList<>();
    }
}
