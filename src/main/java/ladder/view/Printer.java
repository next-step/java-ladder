package ladder.view;

import static ladder.view.ViewString.NEWLINE;

public class Printer {
    public static void print(final String x) {
        System.out.print(x);
    }

    public static void println(final String x) {
        System.out.println(x);
    }

    public static void print(final Object x) {
        System.out.print(x);
    }

    public static void printNewLine() {
        System.out.print(NEWLINE);
    }
}