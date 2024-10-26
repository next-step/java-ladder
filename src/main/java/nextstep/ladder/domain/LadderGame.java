package nextstep.ladder.domain;

public class LadderGame {
    private final Users players;
    private final GameBoard gameBoard;

    public LadderGame(Users players, PositiveNumber height, ResultRow resultRow) {
        this.players = players;
        this.gameBoard = new GameBoard(new PositiveNumber(players.size()), height, resultRow);
    }

    public String getPlayerAsString() {
        return players.getUsersAsString();
    }

    public String getGameBoardAsString() {
        return gameBoard.getGameBoardAsString();
    }
}
