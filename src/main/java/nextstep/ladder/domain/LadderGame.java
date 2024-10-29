package nextstep.ladder.domain;

public class LadderGame {
    private static final String ALL_PLAYER = "all";
    
    private final Users players;
    private final GameBoard gameBoard;

    public LadderGame(Users players, PositiveNumber height, ResultRow resultRow) {
        this.players = players;
        this.gameBoard = new GameBoard(new PositiveNumber(players.size()), height, resultRow);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Users getPlayers() {
        return players;
    }

    public GameResult start(String username) {
        if (username.equals(ALL_PLAYER)) {
            return GameResult.allPlayerGameResult(players, gameBoard);
        }
        return GameResult.singlePlayerGameResult(players, gameBoard, username);
    }
}
