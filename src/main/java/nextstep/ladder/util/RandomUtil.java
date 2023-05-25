package nextstep.ladder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomUtil {

    private static final Random random = new Random();

    public static boolean generator() {
        return random.nextBoolean();
    }

}
