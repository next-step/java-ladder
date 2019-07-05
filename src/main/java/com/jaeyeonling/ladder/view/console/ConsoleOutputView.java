package com.jaeyeonling.ladder.view.console;

import com.jaeyeonling.ladder.domain.GameResult;
import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderReword;
import com.jaeyeonling.ladder.exception.NotFoundUserException;
import com.jaeyeonling.ladder.view.format.Formatters;

import java.io.PrintStream;

public final class ConsoleOutputView {

    private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printLadderReword(final LadderGame ladderGame) {
        newline();
        print(RESULT_LADDER_MESSAGE);
        print(Formatters.usersFormatter.format(ladderGame.getUsers()));
        print(Formatters.ladderGameFormatter.format(ladderGame));
        print(Formatters.ladderRewordsFormatter.format(ladderGame.getRewords()));
        newline();
    }

    public static void printSingleResult(final LadderReword matchingReword) {
        printResult();
        print(Formatters.ladderRewordFormatter.format(matchingReword));
    }

    public static void printGameResult(final GameResult gameResult) {
        printResult();
        print(Formatters.gameResultFormatter.format(gameResult));
    }

    public static void printUserNotFound(final String usernameOfWantReword) {
        print(String.format(NotFoundUserException.ERROR_MESSAGE, usernameOfWantReword));
    }

    static void print(final Object message) {
        CONSOLE.println(message);
    }

    static void newline() {
        CONSOLE.println();
    }

    private static void printResult() {
        newline();
        print(RESULT_MESSAGE);
    }
}
