package nextstep.ladder.domain;

public class GameBoard {
    private final Ladder ladder;
    private final ResultRow resultRow;

    public GameBoard(PositiveNumber width, PositiveNumber height, ResultRow resultRow) {
        this.ladder = new Ladder(width, height);
        this.resultRow = resultRow;
    }

    public String getGameBoardAsString() {
        return getLadderAsString() + "\n" + getResultRowAsString();
    }

    private String getLadderAsString() {
        return ladder.getLadderAsString();
    }

    private String getResultRowAsString() {
        return resultRow.getResultRowAsString();
    }
}
