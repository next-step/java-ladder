package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.util.RandomLineGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class LadderController {

    public static void run() {
        InputView inputView = new InputView(new Scanner(System.in));

        String inputPlayerNames = inputView.inputPlayers();

        int inputVerticalSize = inputView.inputVerticalSize();

        Players players = new Players(inputPlayerNames);
        Ladder ladder = new Ladder(players, inputVerticalSize, new RandomLineGenerator());
        ResultView resultView = new ResultView(ladder);

        resultView.renderLadder();
    }

}
