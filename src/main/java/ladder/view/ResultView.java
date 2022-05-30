package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.exception.NotSupportException;

import java.util.List;

public class ResultView {

    private static final String MESSAGE_RESULT = "실행 결과";

    private ResultView() {
        throw new NotSupportException();
    }

    public static void ladderResultView(Ladder ladder) {
        System.out.println(MESSAGE_RESULT);
        System.out.println(ResultBuilder.ladderResult(ladder));
    }

    public static void searchResultView(List<Result> results) {
        System.out.println(MESSAGE_RESULT);
        System.out.println(ResultBuilder.searchResult(results));
    }
}
