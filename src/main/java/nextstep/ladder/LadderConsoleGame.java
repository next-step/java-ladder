package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderConsoleGame {

    public static void main(String[] args) {
        Players players = InputView.inputParticipants();
        int ladderHeight = InputView.inputLadderHeight();
        LadderGameInitInfo ladderGameInitInfo = LadderGameInitInfo.of(players, ladderHeight);

        LadderGame ladderGame = LadderGame.init(ladderGameInitInfo);

        ResultView.printResult(ladderGame.result());
    }
}
