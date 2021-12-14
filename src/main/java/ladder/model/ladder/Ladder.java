package ladder.model.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(int height, int countOfPlayer) {
        List<Line> lines = new ArrayList<>();
        for (int cnt = 0; cnt < height; cnt++) {
            lines.add(new Line(countOfPlayer));
        }
        return new Ladder(lines);
    }

    public int move(int startIndex) {
        int currentIndex = startIndex;
        for(Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(this.lines);
    }
}
