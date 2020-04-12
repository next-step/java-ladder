package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fixture {

    private static User pobi = new User("pobi");
    private static User honux = new User("honux");
    private static User crong = new User("crong");
    private static User jk = new User("jk");

    public static Users oneUsers() {
        return new Users(Arrays.asList(pobi));
    }

    public static Users twoUsers() {
        return new Users(Arrays.asList(pobi, honux));
    }

    public static Users fourUsers() {
        return new Users(Arrays.asList(pobi, honux, crong, jk));
    }

    public static Ladder fiveHeightLadder() {
        return new Ladder(5, fourUsers());
    }

    public static LadderGoals fourLadderGoals() {
        return new GoalsGenerator("꽝, 5000, 꽝, 5000").generate();
    }
}
