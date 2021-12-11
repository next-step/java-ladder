package nextstep.ladder.view;

import java.util.stream.Collectors;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

public class OutputView {
    private static final String NAME_FORMAT = "%-" + (Name.LENGTH_LIMIT + 1) + "s";
    private static final String NEWLINE = "\n";
    private static final String NOTHING = " ";
    private static final String LINE = "-";
    private static final String RAIL = "|";

    public static void printPlayerList(Players players) {
        players.stream()
                .map(Player::name)
                .map(OutputView::formatName)
                .forEach(System.out::print);
        System.out.print(NEWLINE);
    }

    public static String formatName(Name name) {
        return String.format(NAME_FORMAT, name);
    }

    public static void printLadder(Ladder ladder) {
        ladder.stream()
                .map(OutputView::formatLine)
                .forEach(System.out::println);
    }

    public static String formatLine(Line line) {
        return NOTHING.repeat(Name.LENGTH_LIMIT) + RAIL + mapLine(line) + RAIL;
    }

    public static String mapLine(Line line) {
        return line.stream()
                .map(OutputView::mapPoint)
                .collect(Collectors.joining(RAIL));

    }

    public static String mapPoint(boolean isPoint) {
        String point = isPoint ? LINE : NOTHING;
        return point.repeat(Name.LENGTH_LIMIT);
    }
}
