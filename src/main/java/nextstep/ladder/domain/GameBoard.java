package nextstep.ladder.domain;

public class GameBoard {
    private final Ladder ladder;
    private final ResultRow resultRow;

    public GameBoard(PositiveNumber width, PositiveNumber height, ResultRow resultRow) {
        this.ladder = new Ladder(width, height);
        this.resultRow = resultRow;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prize getLadderResult(Point startPoint) {
        Point resultIndex = ladder.getLadderResultIndex(startPoint);
        return new Prize(resultRow.getResult(resultIndex));
    }

    @Override
    public String toString() {
        return ladder + "\n" + resultRow;
    }
}
