package nextstep.ladder.domain;

import java.util.Random;

import nextstep.ladder.domain.LineStrategy;

public class RandomLineStrategy implements LineStrategy {

    @Override
    public Boolean addLine() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
