package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private Ladder ladder;
    private Users users;
    private Results results;

    public LadderGame(final String userNames,
                      final String results,
                      final int height,
                      final LinesGenerator linesGenerator) {
        this.users = Users.toUsers(userNames);
        this.ladder = new Ladder(linesGenerator, users.userCount(), height);
        this.results = Results.toResults(results, height);
    }

    public void play() {
        for (User user : users.unmodifiableUsers()) {
            user.assignResultPosition(ladder.move(user.currentPosition()));
        }
    }

    public List<String> inGameUserNames() {
        return users.userNames();
    }

    public List<String> inGameResults() {
        return results.results();
    }

    public boolean ladderHasLine(final Line line) {
        return ladder.hasLine(line);
    }

    public String userResult(final String userName) {
        return results.reuslt(users.findUserResultPosition(userName));
    }

    public int ladderWidth() {
        return users.userCount();
    }

    public int ladderHeight() {
        return ladder.height();
    }

}
