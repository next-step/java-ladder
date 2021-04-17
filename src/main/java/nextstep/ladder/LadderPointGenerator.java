package nextstep.ladder;

import java.util.Random;

public class LadderPointGenerator implements DrawRule {
    private static final Random random = new Random();
    @Override
    public boolean isDrawable() {
        return random.nextBoolean();
    }
}
