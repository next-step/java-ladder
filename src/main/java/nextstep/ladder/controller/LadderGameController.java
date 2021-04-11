package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGameMaker;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGameController {

    private final LadderGameMaker ladderGameMaker;

    public LadderGameController(LadderGameMaker ladderGameMaker) {
        this.ladderGameMaker = ladderGameMaker;
    }

    public void run(InputView inputView, ResultView resultView) {
        List<String> playerNames = inputView.receivePlayerNames();
        List<String> rewardStrings = inputView.receiveRewards();
        int ladderHeight = inputView.receiveLadderHeight();

        LadderGame ladderGame = ladderGameMaker.makeRandomLadderGame(playerNames, rewardStrings, ladderHeight);

        resultView.printPlayers(ladderGame.exportPlayerNames());
        resultView.printLadder(ladderGame.exportLadder());
        resultView.printRewards(ladderGame.exportRewards());

        String targetName = inputView.receiveNameForSeeingResult();
        resultView.printLadderGameReport(ladderGame.makeResultReport(targetName));
    }

}
