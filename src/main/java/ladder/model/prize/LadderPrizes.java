package ladder.model.prize;

import java.util.Collections;
import java.util.List;

public class LadderPrizes {
    private List<LadderPrize> ladderPrizes;

    private LadderPrizes(List<LadderPrize> ladderPrizes) {
        this.ladderPrizes = Collections.unmodifiableList(ladderPrizes);
    }

    public static LadderPrizes create(List<LadderPrize> ladderPrizes) {
        return new LadderPrizes(ladderPrizes);
    }

    public List<LadderPrize> getLadderPrizes() {
        return ladderPrizes;
    }

    public String findPrizeNameAtIndex(int index){
        return ladderPrizes.get(index).getPrizeName();
    }

    public int getIndexOfLadderPrize(LadderPrize ladderPrize){
        return ladderPrizes.indexOf(ladderPrize);
    }
}
