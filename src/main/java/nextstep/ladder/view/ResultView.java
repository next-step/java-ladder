package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

import java.util.List;

public class ResultView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String SPACE_HORIZONTAL_LINE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String NAME_LENGTH_FIVE_FORMAT_PATTERN = "%-5s";
    private static final String RESULT_TEXT = "실행결과";

    public static void printResultText() {
        System.out.println(RESULT_TEXT);
    }

    public static void printPlayerName(List<Player> playerList) {
        StringBuilder sb = new StringBuilder();
        playerList.stream().map(Player::getName).forEach(name -> sb.append(String.format(NAME_LENGTH_FIVE_FORMAT_PATTERN, name)).append(" "));
        System.out.print(sb.toString());
    }

    public static void printLadderLine(Line line) {
        System.out.println(getLineText(line.getPoints()));;
    }

    private static String getLineText(List<Boolean> pointList) {
        StringBuilder sb = new StringBuilder();
        pointList.stream()
                .forEach(hasHaveHorizontalLine -> {
                    sb.append(VERTICAL_LINE);
                    if (hasHaveHorizontalLine) sb.append(HORIZONTAL_LINE);
                    if (!hasHaveHorizontalLine) sb.append(SPACE_HORIZONTAL_LINE);
                });
        sb.append(VERTICAL_LINE);
        return sb.toString();
    }

}
