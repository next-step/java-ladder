package ladder;

public class LadderGame {

    private final LadderLinePainter ladderLinePainter;

    public LadderGame(LadderLinePainter ladderLinePainter) {
        this.ladderLinePainter = ladderLinePainter;
    }

    public LadderLines start(Players players, LadderHeight ladderHeight) {
        return ladderLinePainter.drawLines(players, ladderHeight);
    }
}
