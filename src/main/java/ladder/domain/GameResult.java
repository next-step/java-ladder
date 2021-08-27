package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GameResult {

    private final Map<User, LadderResult> result;

    private GameResult(Users users, Ladder ladder, LadderResults ladderResults) {
        result = game(users, ladder, ladderResults);
    }

    private Map<User, LadderResult> game(Users users, Ladder ladder, LadderResults ladderResults) {
        return new HashMap<>();
    }

    public static GameResult create(Users users, Ladder ladder, LadderResults ladderResults) {
        return new GameResult(users, ladder, ladderResults);
    }

    public LadderResult resultOf(User user) {
        if (!result.containsKey(user)) {
            throw new IllegalArgumentException("찾을 수 없는 참여자입니다.");
        }
        return result.get(user);
    }

    public Map<User, LadderResult> getAll() {
        return Collections.unmodifiableMap(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
