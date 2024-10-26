package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameResult {
    private final Map<String, String> result;

    public GameResult() {
        this.result = new LinkedHashMap<>();
    }

    private void put(User user, String ladderResult) {
        result.put(user.getName(), ladderResult);
    }

    public String resultAsString() {
        return result.entrySet().stream()
                .map(it -> it.getKey() + " : " + it.getValue() + "\n")
                .collect(Collectors.joining());
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
        int userIndex = players.findUserIndex(user);
        String ladderResult = gameBoard.getLadderResult(userIndex);
        gameResult.put(user, ladderResult);
    }
}
