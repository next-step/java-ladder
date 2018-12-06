package view;

import Ladder.Lines;
import Ladder.Results;

public class ResultView {
    public static void ladderResultView(Lines lines, Results results) {
        System.out.println("사다리 결과\n\n");
        System.out.println(lines.toString());
        System.out.println(results.toString());
    }

    public static void showResult() {
        System.out.println("실행 결과");

    }
}
