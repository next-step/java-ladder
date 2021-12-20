package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        Players players = Players.of(inputView.players());
        Ladder ladder = Ladder.of(players, Height.of(inputView.height()));
        ResultView.printResult(ladder, players);

        inputView.close();
    }
}
