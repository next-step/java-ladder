package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder() {
    }

    public Ladder(int countOfPerson, int height) {
        this.ladder = createLadder(countOfPerson, height);
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public List<Line> createLadder(int countOfPerson, int height) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(countOfPerson));
        }
        return Collections.unmodifiableList(ladder);
    }
}
