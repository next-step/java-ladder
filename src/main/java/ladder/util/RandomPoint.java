package ladder.util;

import java.util.Random;

public class RandomPoint {

    private static final int SEED = 2;
    private static Random random = new Random();

    private RandomPoint() {}

    public static Boolean generateRandomPoint() {
        int boolRandom = random.nextInt(SEED);
        if( boolRandom == 0){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    public static Boolean nextPoint(Boolean prevPoint){
        if(prevPoint.equals(Boolean.TRUE)) {
            return false;
        }
        return generateRandomPoint();
    }

}
