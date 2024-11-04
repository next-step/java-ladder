package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private static final String ALL_PLAYER = "all";

    private final Users players;
    private final GameBoard gameBoard;

    public LadderGame(Users players, PositiveNumber height, ResultLine resultLine) {
        this.players = players;
        this.gameBoard = new GameBoard(new PositiveNumber(players.size()), height, resultLine);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Users getPlayers() {
        return players;
    }

    public GameResult start(String username) {
        if (username.equals(ALL_PLAYER)) {
            Map<User, Prize> result = new LinkedHashMap<>();
            players.getUsers().forEach(user -> {
                int userIndex = players.findUserIndex(user);
                Prize prize = gameBoard.run(userIndex);
                result.put(user, prize);
            });
            return new GameResult(result);
        }

        User user = players.findUserByName(username);
        int userIndex = players.findUserIndex(user);
        Prize prize = gameBoard.run(userIndex);
        return new GameResult(user, prize);
    }
}
