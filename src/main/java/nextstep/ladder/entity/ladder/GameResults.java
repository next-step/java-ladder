package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.exception.NotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameResults {

    private final List<GameResult> gameResults;

    public GameResults(List<String> gameResults) {
        this.gameResults = gameResults.stream()
                .peek(this::throwIfNull)
                .peek(this::throwIfEmpty)
                .map(GameResult::new)
                .collect(Collectors.toList());
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

    public GameResult getGameResult(int positionInLadder) {
        try {
            return gameResults.get(positionInLadder);
        } catch (IndexOutOfBoundsException e) {
            int total = gameResults.size();
            String message = String.format("올바르지 않은 위치값 입니다. (최소 = 0, 최대 = %d)", total);
            throw new IllegalArgumentException(message);
        }
    }

    public GameResult getGameResult(User user) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.isResultOf(user))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("게임 결과를 찾을 수 없습니다."));
    }

    public List<String> getGameResultValues() {
        return gameResults.stream()
                .map(GameResult::getValue)
                .collect(Collectors.toList());
    }

    public void map(User user, int position) {
        getGameResult(position).map(user);
    }

}
