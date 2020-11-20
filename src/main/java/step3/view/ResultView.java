package step3.view;

import step3.domain.ladder.Ladder;
import step3.domain.ladder.LadderPlayers;

public interface ResultView {
    void drawLadder(LadderPlayers players, Ladder ladder);
}
