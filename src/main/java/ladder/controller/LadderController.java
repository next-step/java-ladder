package ladder.controller;

import ladder.domain.interfaces.Ladder;
import ladder.domain.interfaces.Players;
import ladder.domain.ns.NsRewards;
import ladder.domain.wrapper.PlayerName;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class LadderController {

    public static void run() {
        InputView inputView = new InputView(new Scanner(System.in));

        Players players = inputView.inputNamesToPlayers();
        NsRewards rewards = inputView.inputNamesToRewards(players);
        Ladder ladder = inputView.inputVerticalSizeToLadder(players);

        ResultView resultView = new ResultView();

        resultView.renderLadderAndRewards(ladder, rewards);

        List<PlayerName> playerNames = inputView.inputResultPlayer(players);//결과를 보고 싶은 사람은?
        resultView.renderResults(ladder.results(rewards), playerNames);
    }

}
