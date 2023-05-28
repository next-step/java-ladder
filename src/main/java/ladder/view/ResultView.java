package ladder.view;

import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.LadderReward;
import ladder.domain.Result;

import java.util.List;

public class ResultView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String SPACE_HORIZONTAL_LINE = "     ";
    private static final String SPACE_START_HORIZONTAL_LINE = "    ";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_LENGTH_FIVE_FORMAT_PATTERN = "%5s";
    private static final String RESULT_TEXT = "실행결과";
    private static final String LADDER_COMPLETE_TEXT = "사다리 결과";
    private static final String PLAYER_NAME_AND_RESULT_TEXT = "%s : %s";

    public static void printResult(List<Player> players, List<Line> lines, Result result) {
        printLadderResultText();
        printPlayerName(players);
        printLadderLine(lines);
        printLadderResult(result);
    }

    private static void printLadderResultText() {
        System.out.println(LADDER_COMPLETE_TEXT);
    }

    private static void printPlayerName(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        players.stream()
                .map(Player::getName)
                .forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));

        System.out.println(sb.toString());
    }

    private static void printLadderLine(List<Line> lines) {
        lines.forEach(line -> System.out.println(getLineText(line.getPoints())));
    }

    private static String getLineText(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();

        sb.append(SPACE_START_HORIZONTAL_LINE);
        points.forEach(hasHorizontalLine -> addHorizontalLine(sb, hasHorizontalLine));
        sb.append(VERTICAL_LINE);

        return sb.toString();
    }

    private static void addHorizontalLine(StringBuilder sb, boolean hasHorizontalLine) {
        sb.append(VERTICAL_LINE);
        if (hasHorizontalLine) {
            sb.append(HORIZONTAL_LINE);
        }
        if (!hasHorizontalLine) {
            sb.append(SPACE_HORIZONTAL_LINE);
        }
    }

    private static void printLadderResult(Result result) {
        StringBuilder sb = new StringBuilder();

        result.getValues().stream()
                .forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));

        System.out.println(sb.toString());
    }

    public static void printResultText() {
        System.out.println(RESULT_TEXT);
    }

    public static void printPlayerResult(String result) {
        System.out.println(result);
    }

    public static void printPlayerResultWithName(String playerName, String result) {
        System.out.println(String.format(PLAYER_NAME_AND_RESULT_TEXT, playerName, result));
    }
}
