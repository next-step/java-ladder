package ladder.domain;

import java.util.List;
import java.util.Random;

public class MakeLineWithRandom implements MakeLine {

    private Random random;

    public MakeLineWithRandom() {
        random = new Random();
    }

    @Override
    public Boolean createLine(Boolean beforeLine) {

        if (beforeLine) {
            return false;
        }
        return random.nextBoolean();

    }
}
