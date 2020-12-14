package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private LadderController() {}

    public static void getLadderResult() {
        Users users = enterUsers();
        GameReward gameReward = enterGameReward();
        GameSetup gameSetup = createGameSetup(users.countOfPerson(), InputView.enterHeight());

        Ladder ladder = Ladder.of(users, new Lines(gameSetup));
        ResultView.printGameResult(ladder, gameReward);

        GameResults gameResults = GameResults.of(ladder, gameReward);
        GameManager gameManager = GameManager.of(gameResults);

        showRewardResult(gameManager);
    }

    private static Users enterUsers() {
        return Users.of(InputView.enterUserNames());
    }

    private static GameReward enterGameReward() {
        return GameReward.of(InputView.enterGameReward());
    }

    private static GameSetup createGameSetup(int countOfPerson, int height) {
        return GameSetup.of(countOfPerson, height);
    }

    private static void showRewardResult(GameManager gameManager) {
        String resultKey;
        do {
            resultKey  = InputView.enterGameResultUser();
            ResultView.printGameRewards(gameManager.getResult(resultKey));
        } while(checkResultKey(resultKey));
    }

    private static boolean checkResultKey(String inputKey) {
        return !GameManager.DEFAULT_KEY.equalsIgnoreCase(inputKey);
    }
}
