package nextstep.ladder;

import java.util.Random;

public class RandomLineStrategy implements LineStrategy{
    private Random random = new Random();

    public RandomLineStrategy(){
    }
    public RandomLineStrategy (Random random){
        this.random = random;
    }

    @Override
    public boolean drawLine(boolean lastLine) {
        boolean line = random.nextBoolean();
        if(!lastLine && line)
            return true;
        return false;
    }
}
