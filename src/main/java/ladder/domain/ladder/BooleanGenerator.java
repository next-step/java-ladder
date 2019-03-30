package ladder.domain.ladder;

import ladder.domain.enums.Complexity;

import java.util.Random;

public class BooleanGenerator {

    public static boolean createBooleanByComplexity(Complexity complexity) {
        if (complexity == Complexity.EASY) {
            return false;
        }
        if (complexity == Complexity.HARD) {
            return true;
        }
        return new Random().nextBoolean();
    }
}
