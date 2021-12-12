package nextstep.ladder.view;

import java.util.Collections;
import java.util.stream.Collectors;
import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;

public class ResultView {

    private static final String BLANK = " ";
    private static final String LINE = "-----";
    private static final String STRING_FORMAT = "%6s";
    private static final String DELIMITER_JOIN = "";
    private static final String DELIMITER_LINE = "|";
    private static final int DEFAULT_BLANK_LENGTH = 5;
    private static final int DEFAULT_PLAYER_INDEX = 0;

    private ResultView() {
    }

    public static void outputResult(Players players, Ladder ladder, ExecutionResult executionResult) {
        System.out.println("사다리 결과\n");
        outputPlayer(players);
        outputLadder(players.getPlayer(DEFAULT_PLAYER_INDEX).length(), ladder);
        outputExecutionResult(executionResult);
    }

    private static void outputExecutionResult(ExecutionResult executionResult) {
        String executionResultJoin = executionResult.getExecutionResult()
            .stream()
            .map(result -> String.format(STRING_FORMAT, result))
            .collect(Collectors.joining());

        System.out.println(executionResultJoin.trim());
    }

    private static void outputLadder(int firstBlankLength, Ladder ladder) {
        ladder.getLadder()
            .stream()
            .map(line -> lineFormat(firstBlankLength, line))
            .forEach(System.out::println);
    }

    private static String lineFormat(int firstBlankLength, Line line) {
        String firstBlank = blank(firstBlankLength);

        return firstBlank + DELIMITER_LINE + line.getLine()
            .stream()
            .map(ResultView::lineOrBlank)
            .collect(Collectors.joining(DELIMITER_LINE)) + DELIMITER_LINE;
    }

    private static String blank(int length) {
        return String.join(DELIMITER_JOIN, Collections.nCopies(length, BLANK));
    }

    private static String lineOrBlank(Boolean isLine) {
        return Boolean.TRUE.equals(isLine) ? LINE : blank(DEFAULT_BLANK_LENGTH);
    }

    private static void outputPlayer(Players players) {
        String player = players.getPlayers().stream()
            .map(name -> String.format(STRING_FORMAT, name))
            .collect(Collectors.joining());

        System.out.println(player.trim());
    }

}
