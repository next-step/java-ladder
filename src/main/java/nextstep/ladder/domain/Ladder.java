package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder = new ArrayList<>();

    public Ladder(int line, int height) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(line));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
