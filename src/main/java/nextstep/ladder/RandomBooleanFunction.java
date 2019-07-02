package nextstep.ladder;

import java.util.Random;

public class RandomBooleanFunction implements BooleanFunction {

    private Random random = new Random();

    @Override
    public Boolean apply(Boolean a) {
        if (a) {
            return false;
        }
        return random.nextBoolean();
    }
}
