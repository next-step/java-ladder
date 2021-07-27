package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.LadderInitInfo;
import nextstep.ladder.domain.init.LadderSize;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderConsoleGame {

    public static void main(String[] args) {
        Players players = InputView.inputParticipants();
        int ladderHeight = InputView.inputLadderHeight();
        LadderSize ladderSize = LadderSize.of(players.getNames().size(), ladderHeight);
        LadderInitInfo ladderInitInfo = LadderInitInfo.init(ladderSize, () -> true);
        LadderGameInitInfo ladderGameInitInfo = LadderGameInitInfo.of(ladderInitInfo, players);

        LadderGame ladderGame = LadderGame.init(ladderGameInitInfo);

        ResultView.printResult(ladderGame.result());
    }
}
