package ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(int height, int numberOfPlayers) {
        List<Line> tmpLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            tmpLines.add(Line.from(numberOfPlayers));
        }
        return new Ladder(tmpLines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
