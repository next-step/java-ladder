package ladder.view;

import java.util.stream.Stream;

public class Printer {
    private static final String NEWLINE = System.lineSeparator();

    public static void print(final String x) {
        System.out.print(x);
    }

    public static void println(final String x) {
        System.out.println(x);
    }


    public static void printNewLine() {
        printNewLine(1);
    }
    
    public static void printNewLine(int times) {
        Stream.generate(() -> NEWLINE)
                .limit(times)
                .forEach(System.out::print);
    }
}