package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class LadderController {

    public static void run() {
        InputView inputView = new InputView(new Scanner(System.in));

        Players players = inputView.inputNamesToPlayers();
        Ladder ladder = inputView.inputVerticalSizeToLadder(players);

        ResultView resultView = new ResultView();

        resultView.renderLadder(ladder);
    }

}
