package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class ResultView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String SPACE_HORIZONTAL_LINE = "     ";
    private static final String SPACE_START_HORIZONTAL_LINE = "    ";
    private static final String VERTICAL_LINE = "|";
    private static final String EMPTY = "";
    private static final String NAME_LENGTH_FIVE_FORMAT_PATTERN = "%-6s";
    private static final String RESULT_TEXT = "실행결과";
    private static final String LADDER_RESULT_TEXT = "사다리 결과";
    private static final String PLAYER_NAME_AND_RESULT_TEXT = "%s : %s";
    private static final String ALL_PLAYER = "all";

    public static void printLadderResult(Map<PlayerName, Player> players, List<Line> lines, Map<ResultId, Result> result) {
        System.out.println(LADDER_RESULT_TEXT);
        printPlayerName(players);
        printLadderResult(lines);
        printResultValues(result);
    }

    private static void printPlayerName(Map<PlayerName, Player> players) {
        StringBuilder sb = new StringBuilder();
        players.keySet().forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name.getValue())));
        System.out.println(sb.toString());
    }

    private static void printLadderResult(List<Line> lines) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < lines.size(); index++) {
            sb.setLength(0);
            sb.append(VERTICAL_LINE);
            sb.append(getLinePointsResult(lines.get(index).getPoints()));
            System.out.println(sb.toString());
        }
    }

    private static String getLinePointsResult(List<Point> points) {
        StringBuilder sb = new StringBuilder();
        for (int index = 1; index < points.size(); index++) {
            sb.append(PointStatus.LEFT == points.get(index).getStatus() ? HORIZONTAL_LINE : SPACE_HORIZONTAL_LINE).append(VERTICAL_LINE);;
        }
        return sb.toString();
    }

    private static void printResultValues(Map<ResultId, Result> results) {
        StringBuilder sb = new StringBuilder();
        results.keySet().forEach(resultId -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, results.get(resultId).getValue())).append(" "));
        System.out.println(sb.toString());
    }

    public static void printPlayerResult(String inputPlayer, Map<PlayerName, Player> players) {
        System.out.println(RESULT_TEXT);
        if (ALL_PLAYER.equals(inputPlayer)) {
            players.keySet().forEach(name -> System.out.println(String.format(PLAYER_NAME_AND_RESULT_TEXT, name.getValue(), players.get(name).getResult().getValue())));
            return;
        }
        Player player = players.get(new PlayerName(inputPlayer));
        System.out.println(player.getResult().getValue());
    }
}
