package nextstep.ladder.domain;

public class LadderGame {
    private final LadderConnectionLineConditional drawingMachine;

    public LadderGame(LadderConnectionLineConditional drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    public Ladder createLadder(final LadderGameUsers ladderGameUsers, final int maxHeight) {
        LadderLines ladderLines = new LadderLines();
        for (int orderValue = 1; orderValue <= ladderGameUsers.size(); orderValue++) {
            ladderLines.addLine(Order.of(orderValue), ladderGameUsers.findUserByOrder(orderValue), drawingMachine, maxHeight);
        }
        return Ladder.of(maxHeight, ladderLines);
    }
}
