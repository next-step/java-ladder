package nextstep.ladder.domain;

import java.util.Random;

public class RandomMountingBlockGenerator {

    public static Boolean generateMountingBlock() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
