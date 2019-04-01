package domain.game;

import domain.ladder.Ladders;
import domain.prize.Prizes;
import generator.ladder.LaddersGenerator;
import generator.ladder.impl.RandomLineLaddersGenerator;

public class LaddersAndPrizes {

    private final Ladders ladders;

    private final Prizes prizes;

    public LaddersAndPrizes(int height, Prizes prizes) {
        this(new RandomLineLaddersGenerator(), height, prizes);
    }

    public LaddersAndPrizes(LaddersGenerator laddersGenerator, int height, Prizes prizes) {
        this.prizes = prizes;
        this.ladders = laddersGenerator.generate(height, size());
    }

    public Prizes raffle(int... lineIndexes) {
        return this.prizes.filter(this.ladders.move(lineIndexes));
    }

    public int size() {
        return this.prizes.size();
    }

    public String beautify() {
        return this.ladders.beautify() + "\n" + this.prizes.beautify();
    }
}
