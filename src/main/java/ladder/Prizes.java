package ladder;

import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<Prize> prizes) {
        return new Prizes(prizes);
    }
}
