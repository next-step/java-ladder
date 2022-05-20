package ladder.view;

import ladder.domain.LadderGame;
import ladder.exception.NotSupportException;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행 결과";

    private ResultView() {
        throw new NotSupportException();
    }

    public static void ladderResultView(LadderGame ladderGame) {
        System.out.println(MESSAGE_RESULT);
        System.out.println(ResultBuilder.ladderResult(ladderGame));
    }
}
