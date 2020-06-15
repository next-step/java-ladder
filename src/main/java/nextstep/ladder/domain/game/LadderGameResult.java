package nextstep.ladder.domain.game;

import nextstep.ladder.domain.user.User;

import java.util.Map;
import java.util.Objects;

public class LadderGameResult {

    private final Map<User, Result> userResult;

    public LadderGameResult(Map<User, Result> userResult) {
        if (Objects.isNull(userResult)) {
            throw new IllegalArgumentException("userResult is null");
        }
        this.userResult = userResult;
    }

    public Map<User, Result> getUserResult() {
        return userResult;
    }
}
