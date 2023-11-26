package nextstep.ladder.common.util;

public class RowLinePrinter {

    private static final String SIGN = "-";
    private static final int COUNT = 5;

    public static String generate() {
        return SIGN.repeat(COUNT);
    }
}
