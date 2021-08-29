package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class GameResult {

    private final Map<User, LadderResult> result;

    private GameResult(Users users, Ladder ladder, LadderResults ladderResults) {
        result = game(users, ladder, ladderResults);
    }

    private Map<User, LadderResult> game(Users users, Ladder ladder, LadderResults ladderResults) {
        Map<User, LadderResult> result = new HashMap<>();
        users.getAllWithIdx()
                .forEach(userIdxPair -> {
                    AtomicInteger idx = new AtomicInteger(userIdxPair.getLeft());
                    User user = userIdxPair.getRight();
                    ladder.getLines()
                            .forEach(line -> {
                                if (!line.outOfRange(idx.get() - 1)) {
                                    if (line.isConnected(idx.get() - 1)) {
                                        idx.addAndGet(-1);
                                        return;
                                    }
                                }
                                if (!line.outOfRange(idx.get())) {
                                    if (line.isConnected(idx.get())) {
                                        idx.addAndGet(1);
                                    }
                                }
                            });
                    result.put(user, ladderResults.get(idx.get()));
                });
        return result;
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
