package ladder.domain;

import java.util.Random;

public class LineRandom {
    private static final Random random = new Random();
    private static final int VALID_NUMBER_RANGE = 2;

    private LineRandom() {
    }

    public static boolean random() {
        if(random.nextInt(VALID_NUMBER_RANGE) == 1){
            return true;
        }
        return false;
    }


}
