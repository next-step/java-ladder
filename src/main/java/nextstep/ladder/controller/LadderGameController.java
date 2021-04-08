package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.LadderGameMaker;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void run() {
        Players players = Players.of(inputView.receivePlayerNames());
        Rewards rewards = Rewards.of(inputView.receiveRewards());
        int ladderHeight = inputView.receiveLadderHeight();

        LadderGame ladderGame = LadderGameMaker.makeRandomLadderGame(players, rewards, ladderHeight);

        resultView.printPlayers(players.export());
        resultView.printLadderBoard(ladderGame.exportLadderBoard());

        String targetName = inputView.receiveNameForSeeingResult();
        resultView.printLadderGameReport(ladderGame.getResult(targetName));
    }

}
