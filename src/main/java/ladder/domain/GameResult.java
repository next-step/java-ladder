package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class GameResult {

    private final Map<User, LadderResult> result;

    private GameResult(Users users, Ladder ladder, LadderResults ladderResults) {
        result = game(users, ladder, ladderResults);
    }

    private Map<User, LadderResult> game(Users users, Ladder ladder, LadderResults ladderResults) {
        Map<User, LadderResult> result = new LinkedHashMap<>();
        users.getAllWithLocation()
                .forEach(userLocation -> gameForEachUser(ladder, ladderResults, result, userLocation));
        return result;
    }

    private void gameForEachUser(Ladder ladder, LadderResults ladderResults,
                                 Map<User, LadderResult> result, UserLocation userLocation) {
        User user = userLocation.getUser();
        Location location = userLocation.getLocation();
        ladder.getLines().forEach(line -> moveToLeftOrRight(location, line));
        result.put(user, ladderResults.get(location.now()));
    }

    private void moveToLeftOrRight(Location location, Line line) {
        if (isMovable(location.atLeft(), line)) {
            location.toLeft();
            return;
        }
        if (isMovable(location.now(), line)) {
            location.toRight();
        }
    }

    private boolean isMovable(int pos, Line line) {
        return !line.outOfRange(pos) && line.isConnected(pos);
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

    public Map<User, LadderResult> getAll() {
        return Collections.unmodifiableMap(result);
    }
}
