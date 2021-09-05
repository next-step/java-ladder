package nextstep.ladder;

import java.util.Random;

public class RandomMiddleLadder implements MiddleLadder {
    protected boolean preStatus = false;
    private Random random = new Random();

    @Override
    public boolean makeBoolean() {
        boolean result = !preStatus ? random.nextBoolean() : false;
        preStatus = result;
        return result;
    }

    @Override
    public void resetLine() {
        this.preStatus = false;
    }
}
