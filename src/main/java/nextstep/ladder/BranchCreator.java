package nextstep.ladder;

import java.util.Random;

public class BranchCreator {
    private static Random random = new Random();

    BranchCreator() {
        random = new Random();
    }

    public static boolean createBranchRandomly() {
        return random.nextBoolean();
    }
}
