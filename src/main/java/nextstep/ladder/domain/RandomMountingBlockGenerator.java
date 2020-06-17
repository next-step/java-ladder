package nextstep.ladder.domain;

import java.util.Random;

public class RandomMountingBlockGenerator implements MountingBlockGenerator {

    @Override
    public boolean generateMountingBlock() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
