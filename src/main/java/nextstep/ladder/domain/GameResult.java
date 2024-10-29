package nextstep.ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<User, Prize> result;

    public GameResult() {
        this.result = new LinkedHashMap<>();
    }

    private void put(User user, Prize prize) {
        result.put(user, prize);
    }

    public Map<User, Prize> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public static GameResult allPlayerGameResult(Users players, GameBoard gameBoard) {
        GameResult gameResult = new GameResult();
        players.getUsers().forEach(user -> addUserLadderResult(players, gameBoard, user, gameResult));
        for (User user : players.getUsers()) {
            addUserLadderResult(players, gameBoard, user, gameResult);
        }
        return gameResult;
    }

    public static GameResult singlePlayerGameResult(Users players, GameBoard gameBoard, String username) {
        GameResult gameResult = new GameResult();
        User user = players.findUserByName(username);
        addUserLadderResult(players, gameBoard, user, gameResult);
        return gameResult;
    }

    private static void addUserLadderResult(
            Users players,
            GameBoard gameBoard,
            User user,
            GameResult gameResult
    ) {
        Point userIndex = players.findUserIndex(user);
        Prize prize = gameBoard.getLadderResult(userIndex);
        gameResult.put(user, prize);
    }
}
