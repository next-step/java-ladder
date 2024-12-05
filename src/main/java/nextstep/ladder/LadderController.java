package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.LadderGame;
import nextstep.ladder.domain.laddergame.LadderGameResult;
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

        LadderGame ladderGame = new LadderGame(ladder, ladderResult);
        LadderGameResult ladderGameResult = ladderGame.play();

        ResultView.printGameResult(ladderGameResult);

    }
}
