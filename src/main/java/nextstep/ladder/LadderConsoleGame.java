package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderConsoleGame {

    public static void main(String[] args) {
        List<String> playerNames = InputView.inputParticipantsNames();
        int ladderHeight = InputView.inputLadderHeight();
        LadderGameInitInfo ladderGameInitInfo = LadderGameInitInfo.of(playerNames, ladderHeight);

        LadderGame ladderGame = LadderGame.init(ladderGameInitInfo);

        ResultView.printResult(ladderGame.result());
    }
}
