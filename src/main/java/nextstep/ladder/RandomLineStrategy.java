package nextstep.ladder;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy{

    @Override
    public Boolean addLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
