package domain.ladder;

import java.util.Random;

public class LadderPointGenerator {

    public static final int MAX_NUMBER = 100;

    public static boolean generatePoint(int random){
        return random > new Random().nextInt(MAX_NUMBER);
    }
}
