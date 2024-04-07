package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<String, String> gameResult = new HashMap<>();

    public GameResult(List<String> orderLadderResult, Users users) {
        assertNotEmpty(orderLadderResult, users);
        assertMatchSize(orderLadderResult, users);
        setGameResult(users, orderLadderResult);
    }

    private void assertNotEmpty(List<String> orderLadderResult, Users users) {
        String emptyLadderResultMessage = "[결과] 사다리가 없습니다.";
        String emptyUsersMessage = "[결과] 유저가 없습니다.";

        if (orderLadderResult == null || orderLadderResult.isEmpty()) {
            throw new IllegalArgumentException(emptyLadderResultMessage);
        }

        if (users == null || users.getUsers().isEmpty()) {
            throw new IllegalArgumentException(emptyUsersMessage);
        }
    }

    private void assertMatchSize(List<String> orderLadderResult, Users users) {
        String notMatchSizeMessage = "[결과] 사다리 결과 수와 유저 수가 일치하지 않습니다.";
        if (orderLadderResult.size() != users.getUsers().size()) {
            throw new IllegalArgumentException(notMatchSizeMessage);
        }
    }

    private void setGameResult(Users users, List<String> result) {
        List<String> userNames = users.getUserNames();

        for (int i = 0; i < result.size(); i++) {
            this.gameResult.put(userNames.get(i), result.get(i));
        }
    }

    public String getGameResultByUserName(String userName) {
        String errorMessage = "[결과] 해당 유저는 없습니다.";
        return Optional.ofNullable(gameResult.get(userName))
                .orElseThrow(() -> new NoSuchElementException(errorMessage));
    }
}
