package nextstep.ladder;

import java.util.Collections;
import java.util.List;

public class GameResults {
    private final List<GameResult> gameResults;

    public GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public String getUserResult(User user, List<String> executeResults) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.isSameUser(user))
                .map(GameResult::getResultPosition)
                .map(executeResults::get)
                .findFirst()
                .orElseGet(() -> "[ERROR] 입력된 사람이 사다리게임에 참여하지 않았습니다.");
    }

    public List<GameResult> getGameResults() {
        return Collections.unmodifiableList(gameResults);
    }
}
