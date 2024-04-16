package ladder.model.utils;

import java.util.Random;

public class ConnectLineRandom implements ConnectLine {
    private static final Random RANDOM = new Random();

    @Override
    public boolean next() {
        return RANDOM.nextBoolean();
    }
}
