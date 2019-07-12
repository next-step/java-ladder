package com.jaeyeonling.ladder.view.console;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderGameResult;
import com.jaeyeonling.ladder.domain.line.Direction;
import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.reword.LadderReword;
import com.jaeyeonling.ladder.domain.reword.LadderRewords;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;
import com.jaeyeonling.ladder.utils.StringUtils;

import java.io.PrintStream;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public final class ConsoleOutputView {

    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final String MATCHING_RESULT_FORMAT = "%s : %s";
    private static final String RESULT_LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";

    private static final PrintStream CONSOLE = System.out;

    private ConsoleOutputView() { }

    public static void printLadderReword(final LadderGame ladderGame) {
        newline();
        print(RESULT_LADDER_MESSAGE);
        print(format(ladderGame));
        newline();
    }

    public static void printSingleResult(final Username username,
                                         final LadderReword ladderReword) {
        printResult();
        print(format(username, ladderReword));
    }

    public static void printGameResult(final LadderGameResult ladderGameResult) {
        printResult();
        print(format(ladderGameResult));
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

    private static String format(final LadderGame ladderGame) {
        return format(ladderGame.getUsers()) + NEW_LINE +
                format(ladderGame.getLines()) + NEW_LINE +
                format(ladderGame.getLadderRewords()) + NEW_LINE;
    }

    private static String format(final Users users) {
        return BLANK + users.stream()
                .map(ConsoleOutputView::format)
                .collect(Collectors.joining(BLANK));
    }

    private static String format(final User user) {
        return StringUtils.rightAlign(format(user.getUsername()), Username.MAX_LENGTH);
    }

    private static String format(final Username username) {
        return username.getUsername();
    }

    private static String format(final Lines lines) {
        return lines.stream()
                .map(ConsoleOutputView::format)
                .collect(joining(lineSeparator()));
    }

    private static String format(final Line line) {
        return line.stream()
                .map(ConsoleOutputView::format)
                .collect(joining());
    }

    private static String format(final Direction direction) {
        final String replaceCharacter = direction == Direction.LEFT ? "-" : " ";
        return replaceCharacter.repeat(Username.MAX_LENGTH) + "|";
    }

    private static String format(final LadderRewords ladderRewords) {
        return BLANK + ladderRewords.stream()
                .map(ConsoleOutputView::format)
                .map(reword -> StringUtils.rightAlign(reword, LadderReword.MAX_LENGTH))
                .collect(Collectors.joining(BLANK));
    }

    private static String format(final LadderReword ladderReword) {
        return ladderReword.getLadderReword();
    }

    private static String format(final LadderGameResult ladderGameResult) {
        return ladderGameResult.stream()
                .map(entry -> format(entry.getKey(), entry.getValue()))
                .collect(joining(lineSeparator()));
    }

    private static String format(final Username username,
                                 final LadderReword ladderReword) {
        return String.format(MATCHING_RESULT_FORMAT, format(username), format(ladderReword));
    }
}
