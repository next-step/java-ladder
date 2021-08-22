package ladder;

import ladder.domain.LadderGame;
import ladder.domain.RandomDirectionMakingStrategy;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        String playerNames = inputView.receivePlayerNames();
        int ladderHeight = inputView.receiveLadderHeight();

        LadderGame ladderGame = new LadderGame(new RandomDirectionMakingStrategy());
        Result result = ladderGame.play(playerNames, ladderHeight);
        ResultView.print(result);

        scanner.close();
    }
}
