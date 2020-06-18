package nextstep.step2;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();
    public static Boolean getRandomBoolean() {
      return random.nextBoolean();
    }
}
