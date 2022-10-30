package nextstep.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResults {
    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public static GameResults retrieveResults(Users users, Ladder ladder) {
        List<GameResult> results = new ArrayList<>();
        List<User> userInfos = users.getUsers();
        for (int position = 0; position < users.getSize(); position++) {
            User user = userInfos.get(position);
            int resultPosition = ladder.executeLadder(position);
            results.add(new GameResult(user, resultPosition));
        }
        return new GameResults(results);
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
