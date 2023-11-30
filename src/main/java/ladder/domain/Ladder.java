package ladder.domain;

import java.util.ArrayList;

public class Ladder {

    private final ArrayList<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public Line getLine(int index) {
        return lines.get(index);
    }
}
