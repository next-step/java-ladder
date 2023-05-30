package nextstep.ladder.domain;

import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public String get(int prizeOrder) {
        return prizes.get(prizeOrder);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
