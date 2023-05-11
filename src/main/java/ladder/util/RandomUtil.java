package ladder.util;

import java.util.Random;

public class RandomUtil {

    public static boolean getRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
