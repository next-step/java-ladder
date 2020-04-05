package ladder.domain;

import lombok.Getter;

import java.util.List;

public class LadderGame {
    @Getter
    private Ladder ladder;

    @Getter
    private List<User> users;

    public LadderGame(String userNameValues, String heightValue) {
        this.users = User.listOf(userNameValues);
        this.ladder = new Ladder(this.users.size(), Integer.parseInt(heightValue));
    }
}
