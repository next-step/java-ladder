package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String FLOOR_UNIT = "|";
    private static final String BRIDGE = "-----";
    private static final String EMPTY_BRIDGE = "     ";

    public static void printLadderWithPlayer(Players players, Ladder ladder) {
        System.out.println("\n실행결과");
        printNames(players);
        System.out.println(makeLine(ladder));
    }

    private static void printNames(Players names) {
        String namesOfPersons = names.getPlayers().stream()
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
