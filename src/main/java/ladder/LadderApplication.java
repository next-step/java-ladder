package ladder;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomDirectionStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Scanner;

public class LadderApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String[] userNames = inputView.getInputUserNames();
        int ladderMaxHeight = inputView.getInputLadderMaxHeight();

        LadderGame ladderGame = new LadderGame(ladderMaxHeight, userNames);
        Ladder ladder = ladderGame.start(new RandomDirectionStrategy());

        ResultView.displayLadderGameResult(ladder, userNames);
    }
}
