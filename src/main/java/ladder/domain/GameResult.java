package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class GameResult {

    private final Map<User, LadderResult> result;

    private GameResult(Map<User, LadderResult> result) {
        this.result = result;
    }

    public static GameResult create(Users users, Ladder ladder, LadderResults ladderResults) {
        return new GameResult(game(users, ladder, ladderResults));
    }

    private static Map<User, LadderResult> game(Users users, Ladder ladder, LadderResults ladderResults) {
        Map<User, LadderResult> gameResult = new LinkedHashMap<>();
        for (int i = 0; i < users.size(); i++) {
            gameForEachUser(ladder, ladderResults, gameResult, users.get(i), i);
        }
        return gameResult;
    }

    private static void gameForEachUser(Ladder ladder, LadderResults ladderResults,
                                        Map<User, LadderResult> gameResult, User user, int index) {

        for (LadderLine ladderLine : ladder.getLadderLines()) {
            index = ladderLine.move(index);
        }

        gameResult.put(user, ladderResults.get(index));
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
