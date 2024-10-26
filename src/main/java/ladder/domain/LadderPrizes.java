package ladder.domain;

import java.util.List;

public class LadderPrizes {
    private final List<LadderPrize> prizes;

    public LadderPrizes(List<LadderPrize> prizes) {
        this.prizes = prizes;
    }

    public List<LadderPrize> getPrizes() {
        return prizes;
    }

    public LadderPrize findPrize(int index) {
        return prizes.get(index);
    }
    public int size(){
        return prizes.size();
    }
}
