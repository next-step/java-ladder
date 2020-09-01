package ladder.domain;

import ladder.ui.LadderDataInput;

public class LadderFactory {

    private LadderFactory() { }

    public static Ladder of(LadderDataInput ladderDataInput) {
        return new Ladder(ladderDataInput.getPlayer(), ladderDataInput.getReward(), ladderDataInput.getHeight());
    }
}
