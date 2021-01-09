package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(countOfPerson);
            ladder.add(line);
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }
}
