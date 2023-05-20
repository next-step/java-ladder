package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private Ladder ladder;
    private Users users;

    public LadderGame(final String userNames,
                      final int height,
                      final LinesGenerator linesGenerator) {
        this.users = Users.toUsers(userNames);
        this.ladder = new Ladder(linesGenerator, users.userCount(), height);
    }

    public void play() {
        for (User user : users.unmodifiableUsers()) {
            user.assignResultPosition(ladder.move(user.currentPosition()));
        }
    }

    public List<String> inGameUserNames() {
        return users.userNames();
    }

    public boolean ladderHasLine(final Line line) {
        return ladder.hasLine(line);
    }

    public Position userCurrentPosition(final String userName) {
        return users.findUserResultPosition(userName);
    }

    public int ladderWidth() {
        return users.userCount();
    }

    public int ladderHeight() {
        return ladder.height();
    }

}
