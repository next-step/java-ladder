package ladder.Domain;


import java.util.Random;

public class Climber {

    private Climber() {
    }

    public static Climber init() {
        return new Climber();
    }

    public LadderMap createLadder(String userNames, int height) {
        Users users = Users.of(userNames);
        return LadderMap.of(users, height, () -> new Random().nextInt(10) >= 5);
    }
}
