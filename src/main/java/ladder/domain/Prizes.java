package ladder.domain;

import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = List.copyOf(prizes);
    }

    public List<String> getPrizes() {
        return prizes;
    }
}
