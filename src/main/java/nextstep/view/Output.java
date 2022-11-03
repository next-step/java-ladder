package nextstep.view;

import nextstep.domain.Ladder;
import nextstep.domain.Line;
import nextstep.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    private static final String SPACE_BETWEEN_NAMES = "   ";
    private static final String RESULT_MESSAGE = "\n실행결과\n %s";
    private static final String LADDER_LINE_SPACE = "     ";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";

    public static void printName(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        String result = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(SPACE_BETWEEN_NAMES));

        sb.append(String.format(RESULT_MESSAGE, result));
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        ladder.getLines().stream()
                .forEachOrdered(line -> getLine(sb, line));

        System.out.println(sb);
    }

    private static void getLine(StringBuilder sb, Line line) {
        sb.append(LADDER_LINE_SPACE);
        sb.append(VERTICAL_LINE);
        line.getPoints().stream()
                .forEachOrdered(idx -> sb.append(print(idx)).append(VERTICAL_LINE));
        sb.append("\n");
    }

    private static String print(Boolean idx) {
        if (idx == true) {
            return HORIZONTAL_LINE;
        }
        return LADDER_LINE_SPACE;
    }
}
