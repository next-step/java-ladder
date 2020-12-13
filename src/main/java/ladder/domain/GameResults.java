package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameResults {

    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults of(List<GameResult> gameResults) {
        return new GameResults(gameResults);
    }

    public static GameResults of(Ladder ladder, GameReward gameReward) {
        return new GameResults(makeResults(ladder, gameReward));
    }

    private static List<GameResult> makeResults(Ladder ladder, GameReward gameReward) {
        List<GameResult> gameResults = new ArrayList<>(ladder.getUserCount());

        for (int position = 0; position < ladder.getUserCount(); position++) {
            User user = ladder.getUser(position);
            String reward = gameReward.get(ladder.getFinalPosition(position));
            gameResults.add(GameResult.of(user,reward));
        }
        return gameResults;
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResults that = (GameResults) o;
        return Objects.equals(gameResults, that.gameResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameResults);
    }
}
