package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes;
    }

    public String get(int i) {
        return prizes.get(i);
    }

    public List<String> getAllPrizesName() {
        return new ArrayList<>(prizes);
    }

    public int getPrizeCount() {
        return prizes.size();
    }
}
