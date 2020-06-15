package step2.domain;

import java.util.Random;

public class LineGenerator {
    private static final Random random = new Random();
    private final boolean verticalLine;

    private LineGenerator(boolean value){
        this.verticalLine = value;
    }

    public static boolean generateRandom(){
        return random.nextBoolean();
    }
}
