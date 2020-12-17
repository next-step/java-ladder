package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;

    public LadderGame(Ladder ladder, Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public static LadderGame start(List<String> names, int height, LadderGenerateRule ladderGenerateRule) {
        Users users = Users.of(names);
        Ladder ladder = Ladder.of(height, users.getSize(), ladderGenerateRule);
        return new LadderGame(ladder, users);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<String> getUserNames() {
        return users.getUserNames();
    }
}
