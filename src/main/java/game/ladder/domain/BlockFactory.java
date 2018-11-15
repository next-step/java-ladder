package game.ladder.domain;

import java.util.Random;

public class BlockFactory {
    private static final Random RANDOM = new Random();

    public static Block generateRandomBlock() {
        if (RANDOM.nextBoolean()) {
            return Block.FILLED_BLOCK;
        }

        return Block.EMPTY_BLOCK;
    }

}
