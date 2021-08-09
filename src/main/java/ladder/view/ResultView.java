package ladder.view;

import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.dto.request.PrintResultRequest;
import ladder.dto.response.LadderResult;

public interface ResultView {
    void printResult(PrintResultRequest request);

    void printException(Exception e);

    void printPrizeOwner(LadderResult ladderResult, Player player);

    void printPrizeAll(LadderResult ladderResult, Players players);
}
