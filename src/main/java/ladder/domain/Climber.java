package ladder.domain;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Climber {

    private Users users;

    private Climber() {
    }

    public static Climber of() {
        return new Climber();
    }

    public LadderMap createLadder(String userNames, int height) {
        users = Users.of(userNames);
        CrossRoadStrategy halfPercentCreate = () -> new Random().nextInt(10) >= 5;
        return LadderMap.of(users, height, halfPercentCreate);
    }

    public List<String> getUserNames() {
        return users.toList()
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
