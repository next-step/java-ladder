package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder newLadder(int height, int countOfPerson) {
        List<Line> ladder = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ladder.add(Line.newLine(countOfPerson));
        }

        return new Ladder(ladder);
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int size() {
        return ladder.size();
    }
}
