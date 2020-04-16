package nextstep.ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {
    private LadderLineCreator ladderLineCreator;

    public LadderCreator(LadderLineCreator ladderLineCreator) {
        this.ladderLineCreator = ladderLineCreator;
    }

    public List<LadderLine> create(int countOfPerson, int height) {
        List<LadderLine> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(ladderLineCreator.create(countOfPerson));
        }
        return unmodifiableList(new ArrayList<>(ladder));
    }

}
