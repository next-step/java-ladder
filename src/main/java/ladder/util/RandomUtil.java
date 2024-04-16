package ladder.util;

import java.util.Random;

public class RandomUtil {
    private static Random random = new Random();
    public static Boolean booleanRandom(){
        return random.nextBoolean();
    }
}
