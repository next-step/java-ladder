package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Result;

import java.util.List;

public class ResultView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String SPACE_HORIZONTAL_LINE = "     ";
    private static final String SPACE_START_HORIZONTAL_LINE = "    ";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_LENGTH_FIVE_FORMAT_PATTERN = "%-5s";
    private static final String RESULT_TEXT = "실행결과";
    private static final String PLAYER_NAME_AND_RESULT_TEXT = "%s : %s";

    public static void printLadderResult(List<Player> players, List<Line> lines, Result result) {
        printPlayerName(players);
        printLadderLine(lines);
        printResultValues(result.getValues());
    }

    public static void printResultText() {
        System.out.println(RESULT_TEXT);
    }

    private static void printPlayerName(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        players.stream().map(Player::getName).forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));
        System.out.println(sb.toString());
    }

    private static void printLadderLine(List<Line> lines) {
        lines.forEach(line -> System.out.println(getLineText(line.getPoints())));
    }

    private static String getLineText(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        sb.append(SPACE_START_HORIZONTAL_LINE);
        points.forEach(hasHorizontalLine -> getHorizontalLine(sb, hasHorizontalLine));
        sb.append(VERTICAL_LINE);
        return sb.toString();
    }

    private static void getHorizontalLine(StringBuilder sb, boolean hasHorizontalLine) {
        sb.append(VERTICAL_LINE);
        if (hasHorizontalLine) {
            sb.append(HORIZONTAL_LINE);
        }
        if (!hasHorizontalLine) {
            sb.append(SPACE_HORIZONTAL_LINE);
        }
    }

    private static void printResultValues(List<String> values) {
        StringBuilder sb = new StringBuilder();
        values.stream().forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));
        System.out.println(sb.toString());
    }

    public static void printPlayerResult(String result) {
        printResultText();
        System.out.println(result);
    }

    public static void printPlayerResultWithName(String playerName, String result) {
        printResultText();
        System.out.println(String.format(PLAYER_NAME_AND_RESULT_TEXT, playerName, result));
    }

}
