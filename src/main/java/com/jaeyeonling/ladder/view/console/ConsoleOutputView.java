package com.jaeyeonling.ladder.view.console;

import com.jaeyeonling.ladder.exception.NotFoundUserException;

import java.io.PrintStream;

public final class ConsoleOutputView {

    private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MATCHING_RESULT_FORMAT = "%s : %s";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printLadderReword() {
        newline();
        print(RESULT_LADDER_MESSAGE);
        newline();
    }

    public static void printResult() {
        newline();
        print(RESULT_MESSAGE);
    }

    public static void printMatchingReword(final String username,
                                           final String matchingReword) {
        print(String.format(MATCHING_RESULT_FORMAT, username, matchingReword));
    }

    public static void printUserNotFound(final String usernameOfWantReword) {
        print(String.format(NotFoundUserException.ERROR_MESSAGE, usernameOfWantReword));
    }

    public static void print(final Object message) {
        CONSOLE.println(message);
    }

    public static void newline() {
        CONSOLE.println();
    }
}
