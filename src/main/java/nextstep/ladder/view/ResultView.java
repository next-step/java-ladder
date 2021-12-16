package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

/**
 * @author han
 */
public class ResultView {
    private static final String RESULT = "실행결과";

    public static void print(Ladder ladder) {
        System.out.println(RESULT);
        System.out.println(ladder);
    }
}
