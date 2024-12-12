package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.LadderGame2;
import nextstep.ladder.domain.laddergame.LadderGameResult2;
import nextstep.ladder.domain.laddergame.position.ResultPosition;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderController {

    public static void main(String[] args) {
        Players players = new Players(InputView.getPlayersName());
        LadderResult ladderResult = new LadderResult(InputView.getLadderResult(), players.playerCount());
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = new Ladder(players, ladderHeight);

        ResultView.printLadder(ladder, ladderResult);

        ResultPosition resultPosition = new LadderGame2().play(ladder);
        LadderGameResult2 ladderGameResult2 = resultPosition.match(players, ladderResult);

        ResultView.printGameResult2(ladderGameResult2);
    }
}
