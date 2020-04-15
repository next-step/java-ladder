package nextstep.ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private List<LadderLine> ladder;

    public Ladder(int countOfPerson, int height) {
        this(createLadder(countOfPerson, height));
    }

    public Ladder(List<LadderLine> ladder) {
        this.ladder = unmodifiableList(new ArrayList<>(ladder));
    }

    public static List<LadderLine> createLadder(int countOfPerson, int height) {
        List<LadderLine> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(LadderLine.init(countOfPerson));
        }
        return unmodifiableList(new ArrayList<>(ladder));
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }
}
