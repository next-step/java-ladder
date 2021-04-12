package ladder.domain.nextstep;

import java.util.Random;

public class RandomGenerator {
    private final static Random random = new Random();
    private RandomGenerator(){}
    public static int randomInt(){
        return random.nextInt(2);
    }
}
