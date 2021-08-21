package ladder.model;


import java.util.Random;

public class RandomLineStrategy implements LadderLineStrategy {

    @Override
    public boolean boolLine() {
        Random rand = new Random();
        return rand.nextInt(2) == 1;
    }
}
