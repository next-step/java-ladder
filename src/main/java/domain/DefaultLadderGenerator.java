package domain;

import java.util.Random;

public class DefaultLadderGenerator implements LineStrategy {
    private static final Random rand = new Random();

    @Override
    public boolean generate() {
        if(rand.nextInt(10) > 5) {
            return true;
        }
        return false;
    }
}
