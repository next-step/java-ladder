package nextstep.ladder;

public class ResultView {
    private static final String LINE_SYMBOL_TRUE = "-----";
    private static final String LINE_SYMBOL_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";
    private final static String LADDER_DELIMITER = "\n";


    public static void printLadderResult(Usernames usernames, Lines lines) {
        System.out.println(usernames.toString());
        System.out.println(lines.toString(LADDER_DELIMITER, LINE_DELIMITER, LINE_SYMBOL_TRUE, LINE_SYMBOL_FALSE));
    }

}
