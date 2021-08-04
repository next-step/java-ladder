package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.info.LadderGameInfo;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameController {

    public static void main(String[] args) {
        List<String> playerNames = InputView.inputPlayers();
        List<String> resultCategories = InputView.inputGameResults();
        int ladderHeight = InputView.inputLadderHeight();

        LadderGameInfo ladderGameInfo = LadderGameInfo.of(playerNames, resultCategories, ladderHeight);

        LadderGame ladderGame = LadderGame.of(ladderGameInfo);
        ResultView.printResult(ladderGame.result());
    }

}
