package ladder.model;

import java.util.Random;

public class LadderPointGenerator {
    private static Random random = new Random();
    public static boolean generatePoint() {
        int number = random.nextInt(2);
        System.out.println("random number : " + number);
        if (number == 1) {
            return true;
        }
        return false;
    }
}
