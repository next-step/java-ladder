package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LadderResult;

import java.util.ArrayList;
import java.util.List;

public class HeeSeokLadder implements Ladder {

    private Lines lines;
    private Users users;

    public HeeSeokLadder(Lines lines) {
        this.lines = lines;
    }

    public HeeSeokLadder(Users users, Lines lines) {
        this.users = users;
        this.lines = lines;
    }

    @Override
    public Lines lines() {
        return this.lines;
    }

    @Override
    public Users start() {
        List<User> userResults = new ArrayList<>();
        for (User user : this.users.userList()) {
            int startPosition = lines.calulateGameResult(user.position());
            User newUser = new User(user.name(), startPosition);
            userResults.add(newUser);
        }
        return new Users(userResults);

    }

    @Override
    public LadderResult play(Users users) {
        LadderResult ladderResult = new LadderResult();
        for (User user : users) {
            int resultPosition = lines.calulateGameResult(user.position());
            ladderResult.put(user.position(), resultPosition);
        }
        return ladderResult;
    }
}
