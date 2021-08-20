package nextstep.ladder;

import java.util.Random;

public class RandomLine implements LineStrategy {
    @Override
    public boolean lineAble() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
