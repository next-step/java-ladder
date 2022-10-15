package ladder.step2.domain.partlinestrategy;

import ladder.step2.domain.PartLine;

import java.util.Random;

public class RandomPartLineCreateStrategy implements PartLineCreateStrategy {
    @Override
    public PartLine create() {
        return new PartLine(randomBoolean());
    }
    
    private static boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
