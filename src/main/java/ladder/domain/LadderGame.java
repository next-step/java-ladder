package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final List<Line> ladder = new ArrayList<>();

    public LadderGame(int countOfPerson, int heightOfLadder) {
        while (heightOfLadder > 0) {
            ladder.add(new Line(countOfPerson));
            heightOfLadder--;
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    @Override
    public String toString() {
        return ladder.toString();
    }
}
