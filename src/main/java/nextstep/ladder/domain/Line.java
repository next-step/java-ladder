package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(int height) {
        points = new ArrayList<>(height);
    }
}
