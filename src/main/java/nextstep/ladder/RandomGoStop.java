package nextstep.ladder;

import java.util.Random;

public class RandomGoStop {
    private static final int RANDOM_BOUND = 2;

    public static Direction randomGoStop(){
        if(isSTOP()){
            return Direction.STOP;
        }

        return Direction.RIGTH;
    }

    private static boolean isSTOP(){
        Random random = new Random();
        return random.nextInt(RANDOM_BOUND) == 0;
    }
}
