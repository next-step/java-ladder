package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderPrize {

    private final List<String> prize;

    public LadderPrize(final List<String> prize) {
        this.prize = new ArrayList<>(prize);
    }

    public int size() {
        return prize.size();
    }

    public String getPrize(int prizeIndex) {
        return prize.get(prizeIndex);
    }
}
