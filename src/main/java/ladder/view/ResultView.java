package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.PlayerNames;
import ladder.utils.StringUtils;

public class ResultView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String HEADER = NEWLINE + "실행결과" + NEWLINE;
    public static final String VERTICAL = "|";
    public static final String HORIZONTAL = "-";
    public static final String SPACE = " ";
    public static final int PADDING = 1;

    private ResultView() {}

    public static void printResults(PlayerNames playerNames, Ladder ladder) {
        System.out.println(HEADER);
        printPlayerNames(playerNames);
        printLadder(ladder, playerNames.maxNameLength());
    }

    private static void printPlayerNames(PlayerNames playerNames) {
        int spacing = playerNames.maxNameLength() + PADDING;
        String template = "%" + spacing + "s";
        playerNames.toStrings()
                .stream()
                .map(name -> String.format(template, name))
                .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(Ladder ladder, int spacing) {
        ladder.getLines()
                .stream()
                .map(Line::toBooleans)
                .forEach(line -> printLine(line, spacing));
    }

    public static void printLine(List<Boolean> line, int spacing) {
        List<String> horizontals = line.stream()
                .map(point -> toString(point, spacing))
                .collect(Collectors.toList());
        String row = String.join(VERTICAL, horizontals) + VERTICAL;
        System.out.println(row);
    }

    public static String toString(boolean point, int spacing) {
        if (point) {
            return StringUtils.repeat(HORIZONTAL, spacing);
        }
        return StringUtils.repeat(SPACE, spacing);
    }
}
