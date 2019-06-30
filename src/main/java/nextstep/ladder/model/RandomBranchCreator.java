package nextstep.ladder.model;

import java.util.Random;

public class RandomBranchCreator implements BranchCreator{
    private static Random random = new Random();

    RandomBranchCreator() {
        random = new Random();
    }

    @Override
    public boolean createBranch() {
        return random.nextBoolean();
    }
}
