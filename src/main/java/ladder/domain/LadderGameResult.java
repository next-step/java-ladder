package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderGameResult {
    private final List<User> users;
    private final List<LadderLine> ladderLines;

    public static LadderGameResult of(List<User> users, List<LadderLine> ladderLines) {
        return new LadderGameResult(users, ladderLines);
    }

    private LadderGameResult(List<User> users, List<LadderLine> ladderLines) {
        this.users = Collections.unmodifiableList(users);
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
