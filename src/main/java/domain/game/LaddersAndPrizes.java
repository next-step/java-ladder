package domain.game;

import domain.ladder.Ladders;
import domain.prize.Prizes;

public class LaddersAndPrizes {

    private final Ladders ladders;

    private final Prizes prizes;

    public LaddersAndPrizes(Ladders ladders, Prizes prizes) {
        if (ladders.lineSize() != prizes.size()) {
            throw new IllegalArgumentException();
        }

        this.prizes = prizes;
        this.ladders = ladders;
    }

    public Prizes raffle(int... lineIndexes) {
        return this.prizes.filter(this.ladders.move(lineIndexes));
    }

    public int lineSize() {
        return this.ladders.lineSize();
    }

    public String beautify() {
        return this.ladders.beautify() + "\n" + this.prizes.beautify();
    }
}
