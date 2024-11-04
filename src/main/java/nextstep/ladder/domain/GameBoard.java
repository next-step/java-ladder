package nextstep.ladder.domain;

public class GameBoard {
    private final Ladder ladder;
    private final ResultLine resultLine;

    public GameBoard(PositiveNumber width, PositiveNumber height, ResultLine resultLine) {
        this.ladder = new Ladder(width, height);
        this.resultLine = resultLine;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prize run(int startPoint) {
        int resultIndex = ladder.run(startPoint);
        return new Prize(resultLine.getResult(resultIndex));
    }

    @Override
    public String toString() {
        return ladder + "\n" + resultLine;
    }
}
