package ladder.model;


import java.util.Random;

public class RandomLineStrategy implements LadderLineStrategy {

    private static final Random rand = new Random();

    @Override
    public boolean boolLine() {
        return rand.nextBoolean();
    }
}
