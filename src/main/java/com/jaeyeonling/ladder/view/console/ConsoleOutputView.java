package com.jaeyeonling.ladder.view.console;

import java.io.PrintStream;

public final class ConsoleOutputView {

    private static final String RESULT_MESSAGE = "실행결과";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printResult(final String result) {
        newline();
        print(RESULT_MESSAGE);
        newline();

        print(result);
    }

    public static void print(final Object message) {
        CONSOLE.println(message);
    }

    public static void newline() {
        CONSOLE.println();
    }
}
