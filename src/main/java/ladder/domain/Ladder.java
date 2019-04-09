package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> ladder;
    private final int countOfPerson;
    private final int height;

    public Ladder(int countOfPerson, int height) {
        this.countOfPerson = countOfPerson;
        this.height = height;
        this.ladder = generateLadder();
    }

    private List<Line> generateLadder() {
        List<Line> lines = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
        return lines;
    }

    public int ladderHeight() {
        return ladder.size();
    }

    public int lineCount() {
        return ladder.get(0).lineCount();
    }

    public Line getLine(int index) {
        return ladder.get(index);
    }


}
