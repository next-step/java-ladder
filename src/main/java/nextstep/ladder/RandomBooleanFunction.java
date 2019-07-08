package nextstep.ladder;

import java.util.Random;

public class RandomBooleanFunction implements BooleanFunction {

    private Random random = new Random();

    @Override
    public Boolean apply(Boolean bool) {
        if (bool) {
            return false;
        }
        return random.nextBoolean();
    }
}
