package step4.view;

import step4.domain.ladder.Ladder;
import step4.domain.ladder.LadderGameResults;
import step4.domain.ladder.LadderPlayers;
import step4.domain.ladder.dto.LadderDrawDTO;
import step4.domain.ladder.dto.PlayerWinningInfo;

public interface ResultView {
    void draw(LadderDrawDTO drawDTO);

    void drawLadder(LadderPlayers players, Ladder ladder);

    void drawPlayResult(PlayerWinningInfo playerWinningInfo);

    void drawPlayResultAll(LadderGameResults ladderGameResults);

}
