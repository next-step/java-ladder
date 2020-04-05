package ladder.domain;

import ladder.utils.LadderGenerator;
import lombok.Getter;

import java.util.List;

public class LadderGame {
    @Getter
    private Ladder ladder;

    @Getter
    private List<User> users;

    public LadderGame(String userNameValues, String heightValue) {
        this.users = User.listOf(userNameValues);
        this.ladder = LadderGenerator.createLadder(this.users.size(), Integer.parseInt(heightValue));
    }
}
