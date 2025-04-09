package laddergameRDD;

import java.util.Random;

public class RandomSelectStrategy implements SelectStrategy {
    @Override
    public boolean canSelect() {
        return new Random().nextBoolean();
    }
}
