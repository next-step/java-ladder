package nextstep.ladder.domain;

import java.util.Random;

public class RandomMountingBlockGenerator implements MountingBlockGenerator {

    @Override
    public Boolean generateMountingBlock() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
