package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public void drawLine() {
        ladder.forEach(Line::draw);
    }
}
