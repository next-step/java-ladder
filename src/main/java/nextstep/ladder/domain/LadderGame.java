package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private final LadderLineDrawingMachine drawingMachine;

    public LadderGame(LadderLineDrawingMachine drawingMachine) {
        this.drawingMachine = drawingMachine;
    }

    public Ladder createLadder(final LadderGameUsers ladderGameUsers, final int maxHeight) {
        List<LadderGameUser> gameUsers = ladderGameUsers.getLadderGameUsers();
        Ladder ladder = new Ladder(maxHeight);

        for (LadderGameUser user : gameUsers) {
            ladder.drawLine(user, drawingMachine);
        }

        return ladder;
    }
}
