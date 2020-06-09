package nextstep.ladder.domain;

import java.util.Random;

public class RandomMountingBlockGenerator implements MoutingBlockGenerator {

    @Override
    public Boolean generateMountingBlock() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
