package nextstep.ladder.application;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class LadderService {
    private final LineGenerator lineGenerator;

    public LadderService(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder makeLadder(int height, int numberOfUser, List<String> results) {
        return new Ladder(height, numberOfUser - 1, lineGenerator, results);
    }

    public Users makeUsers(List<String> userNames) {
        List<User> users = userNames.stream().map(User::new).collect(Collectors.toUnmodifiableList());

        return new Users(users);
    }

    public GameResult getGameResult(Ladder ladder, Users users) {
        return ladder.getGameResult(users);
    }

    public boolean isGameResultForAll(String name) {
        return InvalidUserName.ALL.getInvalidName().equalsIgnoreCase(name);
    }
}
