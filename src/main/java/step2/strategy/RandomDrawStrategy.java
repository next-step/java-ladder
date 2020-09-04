package step2.strategy;

import java.util.Random;

public class RandomDrawStrategy implements DrawStrategy{
    private static final Random rand = new Random();
    @Override
    public boolean draw() {
        if(rand.nextInt(100) > 50) {
            return true;
        }
        return false;
    }
}
