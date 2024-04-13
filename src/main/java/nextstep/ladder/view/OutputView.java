package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Rung;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String BRIDGE = "-----";
    private static final String NO_BRIDGE = "     ";
    private static final String UNIT_LADDER = "|";

    public static void printLadder(List<Person> people, LadderGame ladderGame, List<String> results) {
        printPeople(people);
        System.out.print(renderLine(ladderGame));
        printExecutionResult(results);
    }

    private static void printPeople(List<Person> people) {
        System.out.println("\n실행결과");
        String namesOfPersons = people.stream()
                .map(person -> String.format("%5s", person.getName()))
                .collect(Collectors.joining(" "));
        System.out.println(namesOfPersons);
    }

    private static String renderLine(LadderGame ladderGame) {
        return ladderGame.getLines().stream()
                .map(line -> NO_BRIDGE + render(line.getRungs()) + "|\n")
                .collect(Collectors.joining());
    }

    private static String render(List<Rung> rungs) {
        return rungs.stream()
                .map(Rung::isExist)
                .map(point -> UNIT_LADDER + (point ? BRIDGE : NO_BRIDGE))
                .collect(Collectors.joining());
    }

    private static void printExecutionResult(List<String> results) {
        String result = results.stream()
                .map(it -> String.format("%5s", it))
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

}
