package ladder.domain;

import ladder.domain.result.Result;
import ladder.domain.user.User;

import java.util.Map;

public class LadderGameResult {

    private static final String FINISH_STRING = "ALL";

    private final Map<User, Result> ladderGameResult;

    public LadderGameResult(final Map<User, Result> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public boolean isShowAll(final String word) {
        return FINISH_STRING.equalsIgnoreCase(word);
    }

    public Result getResult(String input) {
        return ladderGameResult.get(new User(input));
    }

    public Map<User, Result> getResults() {
        return ladderGameResult;
    }
}
