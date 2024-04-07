package ladder.model.utils;

import java.util.Random;

public class ConnectLine {
    private static final Random RANDOM = new Random();

    public static boolean next() {
        return RANDOM.nextBoolean();
    }
}
