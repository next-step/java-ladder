package ladder;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomDirectionStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

public final class LadderApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String[] userNames = inputView.getInputUserNames();
        String[] resultValues = inputView.getInputResultValues();
        int ladderMaxHeight = inputView.getInputLadderMaxHeight();

        LadderGame ladderGame = new LadderGame(userNames);
        Ladder ladder = ladderGame.generateLadder(ladderMaxHeight, new RandomDirectionStrategy());

        OutputView.displayLadderGameResult(ladder, userNames, resultValues);
    }
}
