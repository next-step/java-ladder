package domain;

import java.util.Random;

public class LadderPointGenerator {
    public static Boolean generatePoint() {
        Random rand = new Random();
        if(rand.nextInt(10) > 5) {
            return true;
        }
        return false;
    }
}
