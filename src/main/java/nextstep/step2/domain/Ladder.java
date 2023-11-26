package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int personCount) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount));
        }
    }

    public List<Line> lines() {
        return lines;
    }
}
