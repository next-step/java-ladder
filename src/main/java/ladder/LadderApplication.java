package ladder;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
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
        OutputView.showLadderGameResult(ladder, userNames, resultValues);

        LadderGameResult ladderGameResult = ladderGame.execute(ladder);
        while (true) {
            String targetUser = inputView.getInputResultValueTarget();

            if (ladderGameResult.isShowAll(targetUser)) {
                OutputView.result(ladderGameResult.getLadderGameResults());
                break;
            }
            Result result = ladderGameResult.getLadderGameResult(targetUser);
            OutputView.result(result);
        }
    }
}
