package nextstep.ladder;

import java.util.Random;

public class RandomGoStop {

    public static Direction randomGoStop(){
        if(isTrue()){
            return Direction.STOP;
        }

        return Direction.RIGTH;
    }

    private static boolean isTrue(){
        Random random = new Random();
        return random.nextInt(2) == 0;
    }
}
