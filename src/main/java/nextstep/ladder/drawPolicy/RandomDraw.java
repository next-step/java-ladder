package nextstep.ladder.drawPolicy;

import java.util.Random;

public class RandomDraw implements DrawablePolicy {

    private static final Random random = new Random();

    public boolean draw() {
        return random.nextBoolean();
    }
}
