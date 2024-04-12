package ladder.util;

import java.util.Random;

public class RandomUtil {
    public static Boolean booleanRandom(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
