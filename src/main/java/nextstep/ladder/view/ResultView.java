package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Point;
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

    private static void printResultValues(List<String> values) {
        StringBuilder sb = new StringBuilder();
        values.stream().forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));
        System.out.println(sb.toString());
    }

}
