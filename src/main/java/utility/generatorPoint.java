package utility;

import java.util.Random;

public class generatorPoint {

    public static boolean makeDirection(){
        Random random = new Random();
        return random.nextBoolean();
    }

}
