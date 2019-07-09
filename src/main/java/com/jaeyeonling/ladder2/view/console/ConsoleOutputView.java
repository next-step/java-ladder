package com.jaeyeonling.ladder2.view.console;

import com.jaeyeonling.ladder2.domain.ladder.LadderGame;
import com.jaeyeonling.ladder2.domain.ladder.LadderGameResult;
import com.jaeyeonling.ladder2.view.Visualizable;

import java.io.PrintStream;

public final class ConsoleOutputView {

    private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printLadderReword(final LadderGame ladderGame) {
        newline();
        print(RESULT_LADDER_MESSAGE);
        print(ladderGame);
        newline();
    }

    public static void printSingleResult(final String s) {
        printResult();
        print(s);
    }

    public static void printGameResult(final LadderGameResult ladderGameResult) {
        printResult();
        print(ladderGameResult);
    }

    static void print(final Object message) {
        CONSOLE.println(message);
    }

    static void newline() {
        CONSOLE.println();
    }

    private static void print(final Visualizable visualizer) {
        print(visualizer.visualize());
    }

    private static void printResult() {
        newline();
        print(RESULT_MESSAGE);
    }
}
