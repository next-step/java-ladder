package ladder.util;

import java.util.Scanner;

public class InputViewUtil {
    private static final String FORMAT = "%5s";

    private InputViewUtil() {
    }

    public static String[] getUserInputSplitBy(String delimiter) {
        return new Scanner(System.in).nextLine()
                .split(delimiter);
    }

    public static String stringLeftPadding(String elem) {
        return String.format(FORMAT, elem);
    }

    public static int getUserInputParseInt() {
        return new Scanner(System.in).nextInt();
    }
}
