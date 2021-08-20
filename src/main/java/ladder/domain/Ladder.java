package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> ladder;

    public Ladder(int countOfPerson, int height) {
        ladder = new ArrayList<>();
        ladder.add(Line.of(height));
        for (int i = 1; i < countOfPerson; i++) {
            ladder.add(Line.of(height, ladder.get(i - 1)));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
