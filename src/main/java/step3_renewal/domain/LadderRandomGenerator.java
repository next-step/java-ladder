package step3_renewal.domain;

import java.util.Random;

public class LadderRandomGenerator implements LadderGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public boolean nextLine() {
        return RANDOM.nextBoolean();
    }
}
