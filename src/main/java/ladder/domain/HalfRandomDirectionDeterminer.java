package ladder.domain;

import java.util.Random;

public final class HalfRandomDirectionDeterminer implements DirectionDeterminer {
    private static final HalfRandomDirectionDeterminer instance = new HalfRandomDirectionDeterminer();

    private final Random random = new Random();

    public static HalfRandomDirectionDeterminer getInstance() {
        return instance;
    }

    @Override
    public boolean isRight() {
        return random.nextInt(10) > 5;
    }
}
