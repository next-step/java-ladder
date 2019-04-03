package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private List<User> users;
    private Ladder ladder;

    public LadderGame(List<String> userNames, Integer height) {
        users = userNames.stream()
            .map(User::new)
            .collect(Collectors.toList());

        ladder = new Ladder(users.size(), height);
    }

    public List<User> getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
