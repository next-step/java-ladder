package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder2 {
    private List<LadderLine> ladder;

    public Ladder2(int countOfPerson, int height) {
        this.ladder = createLadder(countOfPerson, height);
    }

    public Ladder2(List<LadderLine> ladder) {
        this.ladder = Collections.unmodifiableList(ladder);
    }

    public List<LadderLine> createLadder(int countOfPerson, int height) {
        List<LadderLine> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(LadderLine.init(countOfPerson));
        }
        return Collections.unmodifiableList(ladder);
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
