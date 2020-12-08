package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;
import java.util.LinkedList;
import java.util.List;

public class LadderController {

    private LadderController() {}

    public static void ladderCreator() {
        Users users = Users.of(InputView.userName());
        GameReward gameReward = GameReward.of(InputView.ladderGameResult());
        Lines lines = Lines.of(users.countOfPerson(),InputView.inputHeight());

        ResultView.printGameResult(users,lines,gameReward);

        GameManager gameManager = GameManager.of(gameResult(users,lines,gameReward));

        String selectResult = InputView.selectLadderGameResult();
        ResultView.printGameRewards(gameManager.getResult(selectResult));
    }

    private static List<GameResult> gameResult(Users users, Lines lines, GameReward gameReward) {
        List<GameResult> gameResults = new LinkedList<>();
        for (int position = 0; position < users.countOfPerson(); position++) {
            User user = users.get(position);
            String reward = gameReward.get(lines.finalPoint(position));
            gameResults.add(GameResult.of(user,reward));
        }
        return gameResults;
    }
}
