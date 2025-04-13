package ladder.model;

import java.util.List;

public class LadderSession {
    private final Users users;
    private final Ladder ladder;

    public LadderSession(Users users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    public List<String> getNames() {
        return users.getNames();
    }

    public List<LadderLine> getLadderLines() {
        return ladder.getLines();
    }
}
