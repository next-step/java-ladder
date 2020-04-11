package nextstep.ladder.domain.ladder;

import java.util.Random;

class LadderPointGenerator {
    private final static Random RANDOM = new Random();
    static boolean generatePoint(){
        return RANDOM.nextBoolean();
    }
}
