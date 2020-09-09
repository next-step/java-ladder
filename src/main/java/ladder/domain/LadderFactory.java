package ladder.domain;

import ladder.ui.LadderDataInput;

public class LadderFactory {

    private LadderFactory() { }

    public static Ladder of(LadderDataInput ladderDataInput) {
        return new Ladder(ladderDataInput.getPlayerCount(), ladderDataInput.getHeight());
    }
}
