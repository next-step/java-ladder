package ladder.controller;

import ladder.domain.engine.Ladder;
import ladder.domain.engine.PlayerName;
import ladder.domain.engine.Players;
import ladder.domain.engine.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LadderController {

    public static void run() {
        InputView inputView = new InputView(new Scanner(System.in));

        Players players = inputView.inputNamesToPlayers();
        Rewards rewards = inputView.inputNamesToRewards(players);
        Ladder ladder = inputView.inputVerticalSizeToLadder(players);

        ResultView resultView = new ResultView();

        resultView.renderLadderAndRewards(ladder, rewards);

        List<PlayerName> playerNames = inputView.inputResultPlayer(players);//결과를 보고 싶은 사람은?
        resultView.renderResults(ladder.playResults(rewards), playerNames);
    }

}
