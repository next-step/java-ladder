package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameResults {

    private final List<String> gameResults;

    public GameResults(List<String> gameResults) {
        for (String gameResult : gameResults) {
           throwIfNull(gameResult);
           throwIfEmpty(gameResult);
        }
        this.gameResults = gameResults;
    }

    private void throwIfNull(String gameResult) {
        if (Objects.isNull(gameResult)) {
            throw new IllegalArgumentException("게임 결과는 Null일 수 없습니다.");
        }
    }

    private void throwIfEmpty(String gameResult) {
        if (gameResult.isEmpty()) {
            throw new IllegalArgumentException("게임 결과는 빈 문자열일 수 없습니다.");
        }
    }

    public String getGameResult(int positionInLadder) {
        try {
            return gameResults.get(positionInLadder - 1);
        } catch (IndexOutOfBoundsException e) {
            int total = gameResults.size();
            String message = String.format("올바르지 않은 위치값 입니다. (최소=1, 최대=%d)", total);
            throw new IllegalArgumentException(message);
        }
    }

    public List<String> getGameResults() {
        return gameResults;
    }
}
