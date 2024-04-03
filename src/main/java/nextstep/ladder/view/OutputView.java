package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Person;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BRIDGE = "-----";
    private static final String NO_BRIDGE = "-----";
    private static final String UNIT_LADDER = "|";

    public static void printLadder(int height, List<Person> names, LadderGame ladderGame) {
        printHeight(height);
        printNames(names);
        System.out.println(renderLine(ladderGame));
    }

    private static void printHeight(int height) {
        System.out.println(height);
    }

    private static void printNames(List<Person> names) {
        System.out.println("\n실행결과");
        String namesOfPersons = names.stream()
                .map(person -> String.format("%5s", person.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(namesOfPersons);
    }

    private static String renderLine(LadderGame ladderGame) {
        return ladderGame.getLines().stream()
                .map(line -> NO_BRIDGE + renderPoints(line.getPoints()) + "|\n")
                .collect(Collectors.joining());
    }

    private static String renderPoints(List<Boolean> points) {
        return points.stream()
                .map(point -> UNIT_LADDER + (point? BRIDGE : NO_BRIDGE))
                .collect(Collectors.joining());
    }

}
