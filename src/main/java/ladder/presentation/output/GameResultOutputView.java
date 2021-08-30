package ladder.presentation.output;

import ladder.domain.GameResult;
import ladder.domain.LadderResult;
import ladder.domain.User;

public class GameResultOutputView {

    private static final String RESULT_COMMENT = "실행결과";

    public void outputUser(String user, GameResult gameResult) {
        LadderResult ladderResult = gameResult.resultOf(User.create(user));
        System.out.println(RESULT_COMMENT);
        System.out.println(ladderResult.getResult());
        System.out.println();
    }

    public void outputAll(GameResult gameResult) {
        System.out.println(RESULT_COMMENT);
        gameResult.getAll()
                .forEach((user, result) -> System.out.println(user.getName() + " : " + result.getResult()));
    }
}
