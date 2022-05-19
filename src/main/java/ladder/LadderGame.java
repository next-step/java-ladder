package ladder;

import java.util.List;

public class LadderGame {
    private List<User> users;

    public LadderGame(List<User> users) {
        this.users = users;
    }

    public Ladder createLadder(int maxHeight) {
        return new Ladder(maxHeight, users);
    }
}
