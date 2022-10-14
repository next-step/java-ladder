package nextstep.ladder.model.strategy;

import java.util.Random;

public class RandomPointPickerStrategy implements PointPickerStrategy {
    private final Random random = new Random();

    @Override
    public boolean makePoint() {
        return random.nextBoolean();
    }
}
