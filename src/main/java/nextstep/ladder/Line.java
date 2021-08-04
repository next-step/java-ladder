package nextstep.ladder;

import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private static final String LINE = "-----|";
    private static final String NONE_LINE = "     |";


    private static String lines;

    public static String drawLine(int maxNum) {
        lines = "    |";

        for (int i = 1; i < maxNum; i++) {
            oddOrEven(random.nextInt(2) + 1);
        }

        return lines;
    }

    private static void oddOrEven(int number) {
        if (number % 2 == 0) {
            previousCheck();
            return;
        }
        lines += NONE_LINE;
    }

    private static void previousCheck() {
        if (lines.charAt(lines.length() - 2) == '-') {
            lines += NONE_LINE;
            return;
        }
        lines += LINE;
    }
}
