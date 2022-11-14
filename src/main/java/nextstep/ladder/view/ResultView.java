package nextstep.ladder.view;

import java.util.List;
import java.util.function.Consumer;
import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.PlayerName;

public final class ResultView {

    private static final String BLANK = " ";
    private static final String SEPARATOR_STYLE = "|";
    private static final String EMPTY_LINE_STYLE = " ";
    private static final String LINE_STYLE = "-";
    private static final int EDGE_REPEAT_COUNT = PlayerName.MAX_NAME_LENGTH;
    private static final int PLAYER_NAMES_SUFFIX_SPACE_COUNT = 1;

    private static final String SEPARATOR = SEPARATOR_STYLE;
    private static final String LADDER_LINE = LINE_STYLE.repeat(EDGE_REPEAT_COUNT);
    private static final String EMPTY_LADDER_LINE = EMPTY_LINE_STYLE.repeat(EDGE_REPEAT_COUNT);

    private static final String RESULT_TITLE = "실행결과";

    private ResultView() {
    }

    private static void printLine(final String message) {
        System.out.println(message);
    }

    private static void print(final String message) {
        System.out.print(message);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

    public static void printResult(final List<String> playerNames, final List<LadderLine> ladderLines) {
        printResultTitle();
        printEmptyLine();
        printPlayerNames(playerNames);
        printEmptyLine();
        printLadderLines(ladderLines);
    }

    private static void printResultTitle() {
        printLine(RESULT_TITLE);
    }

    private static void printPlayerNames(final List<String> playerNames) {
        playerNames.forEach(ResultView::printPlayerName);
    }

    private static void printPlayerName(final String playerName) {
        print(createPlayerNameMessage(playerName));
    }

    private static String createPlayerNameMessage(final String playerName) {
        return new StringBuilder()
            .append(createPlayerNamePrefixSpaces(playerName))
            .append(playerName)
            .append(createPlayerNameSuffixSpaces())
            .toString();
    }

    private static String createPlayerNamePrefixSpaces(final String playerName) {
        return BLANK.repeat(PlayerName.MAX_NAME_LENGTH - playerName.length());
    }

    private static String createPlayerNameSuffixSpaces() {
        return BLANK.repeat(PLAYER_NAMES_SUFFIX_SPACE_COUNT);
    }

    private static void printLadderLines(final List<LadderLine> ladderLines) {
        ladderLines.forEach(ladderLine -> {
            printEmptyLadderLineWithSeparator();
            IterateLadderLine(ladderLine, ResultView::printLadderLineIfConnected);
            printEmptyLine();
        });
    }

    private static void IterateLadderLine(final LadderLine ladderLine, final Consumer<Boolean> ladderLinerPrinter) {
        for (int i = 1; i < ladderLine.size(); i++) {
            ladderLinerPrinter.accept(ladderLine.isNode(i));
        }
    }

    private static void printLadderLineIfConnected(final boolean isLadderLineConnected) {
        if (isLadderLineConnected) {
            printLadderLineWithSeparator();
            return;
        }
        printEmptyLadderLineWithSeparator();
    }

    private static void printEmptyLadderLineWithSeparator() {
        print(EMPTY_LADDER_LINE + SEPARATOR);
    }

    private static void printLadderLineWithSeparator() {
        print(LADDER_LINE + SEPARATOR);
    }


}
