package laddergame.domain;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.RandomSelectStrategy;
import laddergame.domain.user.Name;
import laddergame.domain.user.Users;

import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;

    public LadderGame(String nameString, String resultString, int maxLadderHeight) {
        users = new Users(nameString, resultString);
        ladder = new Ladder(maxLadderHeight, users.getUserCount(), new RandomSelectStrategy());
    }

    public Map<Name, String> play() {
        Map<Integer, Integer> ladderResult = ladder.makeGameResult();
        return users.makeGameResult(ladderResult);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Name> getUserNames() {
        return users.getUserNames();
    }

    public List<String> getResults() {
        return users.getResults();
    }
}
