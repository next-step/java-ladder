package nextstep.ladder.domain;

import java.util.Random;

public class LadderGenerateRule {

    private final Random random = new Random();

    public boolean generate() {
        return random.nextBoolean();
    }
}
