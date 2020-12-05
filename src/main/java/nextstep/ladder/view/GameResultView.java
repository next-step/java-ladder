package nextstep.ladder.view;

import nextstep.ladder.entity.User;
import nextstep.ladder.entity.ladder.GameResults;

public class GameResultView extends AbstractView {

    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void displayResult(String gameResult) {
        stringBuilder.append(GAME_RESULT_MESSAGE);
        printAndClear();

        stringBuilder.append(gameResult);
        printAndClear();
    }

    public static void displayResultWithUserName(User user, String gameResult) {
        stringBuilder.append(user.getName());
        stringBuilder.append(" : ");
        stringBuilder.append(gameResult);
        printAndClear();
    }
}
