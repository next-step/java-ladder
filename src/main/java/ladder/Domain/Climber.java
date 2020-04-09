package ladder.Domain;


import java.util.List;
import java.util.Random;

public class Climber {

    private Users users;

    private Climber() {
    }

    public static Climber of() {
        return new Climber();
    }

    public LadderMap createLadder(String userNames, int height) {
        users = Users.of(userNames);
        return LadderMap.of(users, height, () -> new Random().nextInt(10) >= 5);
    }

    public List<String> getUserNames() {
    }
}
