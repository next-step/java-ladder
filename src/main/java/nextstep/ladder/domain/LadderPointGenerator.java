package nextstep.ladder.domain;

import java.util.Random;

public class LadderPointGenerator {

    public static boolean generatePoint() {
        return new Random().nextBoolean();
    }

}
