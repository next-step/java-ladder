package step2.view;

import step2.domain.ladder.Ladder;
import step2.domain.ladder.LadderPlayers;

public interface ResultView {
    void drawLadder(LadderPlayers players, Ladder ladder);
}
