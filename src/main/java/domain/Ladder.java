package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladder;

    private Ladder(final List<LadderLine> ladder) {
        this.ladder = ladder;
    }

    public static Ladder init(final int ladderHeight, final int numberOfPeople) {
        List<LadderLine> ladder = new ArrayList<>();
        for(int i = 0; i < ladderHeight; i++) {
            ladder.add(LadderLine.init(numberOfPeople));
        }

        return new Ladder(ladder);
    }

    public List<LadderLine> getLadder() {
        return ladder;
    }

    public int move(int index) {
        for(int i = 0; i < ladder.size(); i++) {
            index = ladder.get(i).move(index);
        }

        return index;
    }
}
