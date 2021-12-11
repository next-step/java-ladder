package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Player;

public class OutputView {
    public static final String NAME_FORMAT = "%-" + (Name.LENGTH_LIMIT + 1) + "s";
    public static final String NEWLINE = "\n";
    public static final String NOTHING = " ";
    public static final String LINE = "-";
    public static final String RAIL = "|";


    public static void printPlayerList(List<Player> players) {
        players.stream()
                .map(Player::name)
                .map(OutputView::formatName)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static String formatName(Name name) {
        return String.format(NAME_FORMAT, name);
    }

    public static void printLadder(List<Line> ladder) {
        ladder.stream()
                .map(OutputView::mapLine)
                .map(line -> NOTHING.repeat(5) + RAIL + line)
                .forEach(System.out::println);
    }

    public static String mapLine(Line line) {
        return line.stream()
                .map(OutputView::mapPoint)
                .collect(Collectors.joining(RAIL));

    }

    public static String mapPoint(boolean isPoint) {
        String point = isPoint ? LINE : NOTHING;
        return point.repeat(5);
    }
}
