package nextstep.ladder.application;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LineGenerator;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

public class LadderService {
    private final LineGenerator lineGenerator;

    public LadderService(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder makeLadder(int height, int numberOfUser, List<String> results) {
        return new Ladder(height, numberOfUser-1, lineGenerator, results);
    }

    public Users makeUser(List<String> userNames) {
        List<User> users = userNames.stream().map(User::new).collect(Collectors.toUnmodifiableList());

        return new Users(users);
    }
}
