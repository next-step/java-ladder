package step3.view;

import step3.domain.ladder.Ladder;
import step3.domain.ladder.LadderGameResults;
import step3.domain.ladder.LadderPlayers;
import step3.domain.ladder.dto.LadderDrawDTO;
import step3.domain.ladder.dto.PlayerWinningInfo;

public interface ResultView {
    void draw(LadderDrawDTO drawDTO);
    void drawLadder(LadderPlayers players, Ladder ladder);

    void drawPlayResult(PlayerWinningInfo playerWinningInfo);

    void drawPlayResultAll(LadderGameResults ladderGameResults);

}
