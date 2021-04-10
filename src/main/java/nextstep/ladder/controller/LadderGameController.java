package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGameMaker;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        List<String> playerNames = inputView.receivePlayerNames();
        List<String> rewardStrings = inputView.receiveRewards();
        int ladderHeight = inputView.receiveLadderHeight();

        LadderGame ladderGame = LadderGameMaker.makeRandomLadderGame(playerNames, rewardStrings, ladderHeight);

        resultView.printPlayers(ladderGame.exportPlayerNames());
        resultView.printLadderBoard(ladderGame.exportLadderBoard());

        String targetName = inputView.receiveNameForSeeingResult();
        resultView.printLadderGameReport(ladderGame.makeResultReport(targetName));
    }

}
