package nextstep.ladder.domain;

import java.util.Random;

public class MountingBlockGenerator {

    public Boolean generateMountingBlock() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
