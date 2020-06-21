package ladder.view;

import ladder.domain.ladder.Ladder;

public class ResultView {
    public static void printResult(Ladder ladder) {
        System.out.println("실행 결과");
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }
}
