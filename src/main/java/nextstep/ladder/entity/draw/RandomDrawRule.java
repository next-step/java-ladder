package nextstep.ladder.entity.draw;

import java.util.Random;

public class RandomDrawRule implements DrawRule {
    @Override
    public boolean drawRule() {
        return new Random().nextBoolean();
    }
}
