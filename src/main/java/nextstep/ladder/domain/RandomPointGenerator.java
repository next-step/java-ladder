package nextstep.ladder.domain;

import java.util.Random;

public class RandomPointGenerator implements PointGenerator{

    private static final Random random = new Random();

    public Boolean generate(){
        return random.nextBoolean();
    }
}
