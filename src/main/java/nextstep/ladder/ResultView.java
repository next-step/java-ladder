package nextstep.ladder;

public class ResultView {
    private static final String LINE_SYMBOL_TRUE = "-----";
    private static final String LINE_SYMBOL_FALSE = "     ";

    public static void printLadderResult(Usernames usernames, Lines lines) {
        System.out.println(usernames.toString());
        System.out.println(lines.toString(LINE_SYMBOL_TRUE, LINE_SYMBOL_FALSE));
    }

}
