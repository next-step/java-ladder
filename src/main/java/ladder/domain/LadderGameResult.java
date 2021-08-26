package ladder.domain;

import ladder.domain.result.Result;
import ladder.domain.user.User;

import java.util.Map;

public class LadderGameResult {

    public static final String FINISH_KEYWORD = "ALL";
    private static final Result RESULT_EMPTY = Result.valueOf("해당 유저가 없습니다.");

    private final Map<User, Result> ladderGameResult;

    public LadderGameResult(final Map<User, Result> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public boolean isShowAll(final String word) {
        return word.equalsIgnoreCase(FINISH_KEYWORD);
    }

    public Result getLadderGameResult(String input) {
        return ladderGameResult.getOrDefault(User.valueOf(input), RESULT_EMPTY);
    }

    public Map<User, Result> getLadderGameResults() {
        return ladderGameResult;
    }
}
