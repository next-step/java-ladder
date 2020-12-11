package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private LadderController() {}

    public static void ladderCreator() {
        Users users = Users.of(InputView.userName());
        GameReward gameReward = GameReward.of(InputView.ladderGameResult());
        GameSetup gameSetup = GameSetup.of(users.countOfPerson(),InputView.inputHeight());
        Lines lines = Lines.of(gameSetup, new NextDirectionRule());

        ResultView.printGameResult(users,lines,gameReward);

        GameManager gameManager = GameManager.of(GameResults.of(users,lines,gameReward));
        viewGameResult(gameManager);
    }

    private static void viewGameResult(GameManager gameManager) {
        final String defaultKey = GameManager.getDefaultKey();
        String resultKey;
        do {
            resultKey  = InputView.selectLadderGameResult();
            ResultView.printGameRewards(gameManager.getResult(resultKey));
        } while(defaultResultKeyCheck(defaultKey,resultKey));
    }

    private static boolean defaultResultKeyCheck(String defaultKey, String inputKey) {
        return !defaultKey.equals(inputKey.toLowerCase());
    }
}
