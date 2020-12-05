package nextstep.ladder.view;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.ladder.GameResult;
import nextstep.ladder.entity.ladder.GameResults;
import nextstep.ladder.entity.ladder.Users;

public class GameResultView extends AbstractView {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void displaySingleResult(GameResult gameResult) {
        stringBuilder.append(GAME_RESULT_MESSAGE);
        printAndClear();

        stringBuilder.append(gameResult.getValue());
        printAndClear();
    }

    public static void displayResultWithUserName(Users users, GameResults gameResults) {
        stringBuilder.append(GAME_RESULT_MESSAGE);
        printAndClear();

        for (int position = 1; position <= users.getUserCount(); position++) {
            User user = users.at(position);
            GameResult gameResult = gameResults.getGameResult(user);
            stringBuilder.append(gameResultView(gameResult));
            printAndClear();
        }
    }

    private static String gameResultView(GameResult gameResult) {
        return String.format("%s : %s", gameResult.getUser().getName(), gameResult.getValue());
    }
}
