package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String FLOOR_UNIT = "|";
    private static final String BRIDGE = "-----";
    private static final String EMPTY_BRIDGE = "     ";

    public static void printLadderWithPlayer(List<Player> names, Ladder ladder) {
        System.out.println("\n실행결과");
        printNames(names);
        System.out.println(makeLine(ladder));
    }

    private static void printNames(List<Player> names) {
        String namesOfPersons = names.stream()
                .map(person -> String.format("%5s", person.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(namesOfPersons);
    }

    private static String makeLine(Ladder ladder) {
        return ladder.getLines().stream()
                .map(line -> EMPTY_BRIDGE + makePoints(line.getPoints()) + "|\n")
                .collect(Collectors.joining());
    }

    private static String makePoints(List<Point> points) {
        return points.stream()
                .map(point -> FLOOR_UNIT + (point.exist()? BRIDGE : EMPTY_BRIDGE))
                .collect(Collectors.joining());
    }
}
