package domain.ladder;

import java.util.Random;

public class LadderPointGenerator {

    public static boolean generatePoint(){
        return new Random().nextBoolean();
    }
}
