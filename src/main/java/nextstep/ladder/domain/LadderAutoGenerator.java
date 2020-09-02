package nextstep.ladder.domain;

import java.util.Random;

public class LadderAutoGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public boolean right() {
        return random.nextBoolean();
    }

}
