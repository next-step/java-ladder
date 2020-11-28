package ladder.view;

public class Printer {
    private static final String NEWLINE = System.lineSeparator();

    public static void print(final String x) {
        System.out.print(x);
    }

    public static void println(final String x) {
        System.out.println(x);
    }

    public static void printNewLine() {
        System.out.print(NEWLINE);
    }
}