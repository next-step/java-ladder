package ladder.view;

import ladder.domain.Ladder;

public class ResultView {

    private static final String ALL_RESULT = "all";

    public static void printNames(String playerNames) {
        System.out.println(playerNames);
    }

    public static void printLadder(Ladder ladder) {
        System.out.println();
        System.out.println(ladder.toString());
    }

    public static void printWinnings(String winnings) {
        System.out.println(winnings);
    }

    public static void printResults(String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
