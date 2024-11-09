package nextstep.ladder;

public class ResultView {
    private static final String LINE_SYMBOL_TRUE = "-----";
    private static final String LINE_SYMBOL_FALSE = "     ";

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.getLadderForPrint(LINE_SYMBOL_TRUE, LINE_SYMBOL_FALSE));
    }

    public static void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

}
