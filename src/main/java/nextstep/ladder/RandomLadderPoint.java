package nextstep.ladder;

import java.util.Random;

public class RandomLadderPoint implements RandomPoint {
    private Random random = new Random();
    protected boolean preStatus = false;
    @Override
    public boolean makeBoolean() {
        boolean result = !preStatus ? random.nextBoolean() : false;
        preStatus = result;
        return result;
    }
}
