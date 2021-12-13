package nextstep.ladder.view;

import java.text.MessageFormat;

public final class PrintUtils {

    private PrintUtils() {
    }

    public static void printSpace() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String pattern, Object... arguments) {
        System.out.println(MessageFormat.format(pattern, arguments));
    }

}
