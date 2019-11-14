package ladder.domain;

import java.util.Random;

public class RandomHorizontalPointGeneratorPolicy implements HorizontalPointGeneratorPolicy {

    @Override
    public boolean getResult() {
        return new Random().nextBoolean();
    }
}
