package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Prize;
import ladder.dto.response.LadderResult;

public interface ResultView {
    void printResult(LadderResult ladderResult, Players players);

    void printException(Exception e);

    void printPrize(LadderResult ladderResult, Player player);

    void printPrizeAll(LadderResult ladderResult, Players players);
}
