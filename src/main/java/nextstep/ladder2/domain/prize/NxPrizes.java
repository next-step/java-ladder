package nextstep.ladder2.domain.prize;

import java.util.List;

public class NxPrizes {
    private final List<NxPrize> prizes;

    public NxPrizes(List<NxPrize> prizes) {
        this.prizes = prizes;
    }

    public NxPrize getPrizeByIndex(int index) {
        return prizes.get(index);
    }
}
