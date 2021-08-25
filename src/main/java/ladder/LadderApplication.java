package ladder;

import ladder.domain.LadderGame;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.RandomDirectionStrategy;
import ladder.domain.result.Result;
import ladder.domain.user.User;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public final class LadderApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        // Todo
        String[] userNames = inputView.getInputUserNames();
        String[] resultValues = inputView.getInputResultValues();
        List<String> userList = Arrays.asList(userNames);
        List<String> resultList = Arrays.asList(resultValues);

        LadderGame ladderGame = new LadderGame(userList, resultList);
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
