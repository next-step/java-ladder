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

        for (int userIndex = 0, size = gameUsers.size(); userIndex < size - 1; userIndex++) {
            ladder.drawLine(gameUsers.get(userIndex), drawingMachine);
        }

        return ladder;
    }
}
