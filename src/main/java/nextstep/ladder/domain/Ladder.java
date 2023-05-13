package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int BEGIN_INDEX = 0;

    private final People people;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(People people, int height) {
        this.people = people;
        makeLadder(height);
    }

    private void makeLadder(int height) {
        for (int i = BEGIN_INDEX; i < height; i++) {
            addLine();
        }
    }

    private void addLine() {
        lines.add(new Line(people.value().size()));
    }

    public People people() {
        return people;
    }

    public List<Line> lines() {
        return this.lines;
    }
}
