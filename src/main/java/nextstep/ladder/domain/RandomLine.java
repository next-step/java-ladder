package nextstep.ladder.domain;

import java.util.Random;

public class RandomLine {

    public static boolean getRandomValue() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
