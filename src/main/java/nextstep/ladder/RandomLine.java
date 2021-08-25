package nextstep.ladder;

import java.util.Random;

public class RandomLine implements LineStrategy {

    private Random random = new Random();

    @Override
    public boolean lineAble() {
        return random.nextBoolean();
    }
}
