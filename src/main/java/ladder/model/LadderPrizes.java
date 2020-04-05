package ladder.model;

import java.util.Collections;
import java.util.List;

public class LadderPrizes {
    private List<LadderPrize> ladderPrizes;

    public LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = Collections.unmodifiableList(ladderPrizes);
    }

    public static LadderPrizes create(List<LadderPrize> ladderPrizes) {
        return null;
    }
}
