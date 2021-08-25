package ladder;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomDirectionStrategy;
import ladder.domain.result.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;
import java.util.Scanner;

public final class LadderApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        List<String> userNames = inputView.getInputUserNames();
        List<String> resultValues = inputView.getInputResultValues();

        LadderGame ladderGame = new LadderGame(userNames, resultValues);
        int ladderMaxHeight = inputView.getInputLadderMaxHeight();
        Ladder ladder = ladderGame.generateLadder(ladderMaxHeight, new RandomDirectionStrategy());

        OutputView.displayLadderGameResult(ladder, userNames, resultValues);

        while (true) {
            String targetUser = inputView.getInputResultValueTarget();
            if (targetUser.equals("all")) {
                OutputView.result(ladderGame.execute(ladder));
                break;
            }
            Result result = ladderGame.execute(ladder, targetUser);
            OutputView.result(result);
        }
    }
}
