package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladder;

    public Ladder(int countOfPerson, int height) {
        this.ladder = createLadder(countOfPerson, height);
    }

    public Ladder(List<LadderLine> ladder) {
        this.ladder = Collections.unmodifiableList(new ArrayList<>(ladder));
    }

    public List<LadderLine> createLadder(int countOfPerson, int height) {
        List<LadderLine> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(LadderLine.init(countOfPerson));
        }
        return Collections.unmodifiableList(new ArrayList<>(ladder));
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
