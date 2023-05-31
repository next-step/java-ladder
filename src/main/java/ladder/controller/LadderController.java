package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private InputView inputView;
    private ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        List<String> playerNames = inputView.readPlayerNames();
        List<String> prizeNames = inputView.readPrizeNames();
        int height = inputView.readHeight();

        Players players = new Players(playerNames);
        Prizes prizes = new Prizes(prizeNames);
        Ladder ladder = new Ladder(height, players.size());
        resultView.printLadder(ladder, players, prizes);

        Result result = ladder.play(players, prizes);
        String searchKey = inputView.readSearchKeyPlayer();
        resultView.printResult(result, searchKey);
    }
}
