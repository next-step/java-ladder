package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(People people, int height) {


        for (int i = 0; i < height; i++) {
            lines.add(new Line(people.size()));
        }

    }

    public List<Line> lines() {
        return this.lines;
    }
}
