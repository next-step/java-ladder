package nextstep.ladder.domain;

import java.util.Random;

public class LadderLineStrategy implements LineStrategy {
    private static final int DIVIDE_NUMBER = 2;
    private static final int DO_NOT_MAKE_ZERO = 1;

    @Override
    public boolean createLine() {
        return getRandomNum() / DIVIDE_NUMBER == 0;
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(DIVIDE_NUMBER) + DO_NOT_MAKE_ZERO;
    }
}
