package nextstep.ladder.domain;

import java.util.Random;

public class RandomCreateStrategy implements CreateStrategy {

    @Override
    public boolean isCreate() {
        int number = new Random().nextInt(10);

        if (number < 4) {
            return true;
        }

        return false;
    }
}
