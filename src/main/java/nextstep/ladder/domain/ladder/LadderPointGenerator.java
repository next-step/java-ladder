package nextstep.ladder.domain.ladder;

import java.util.Random;

public class LadderPointGenerator {

    private LadderPointGenerator(){
    }

    private static final Random random = new Random();

    public static boolean generatePoint(){
        return random.nextBoolean();
    }
}
