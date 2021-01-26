package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder newLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(Line.newLine(countOfPerson));
        }

        return new Ladder(ladder);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int size() {
        return lines.size();
    }
}
