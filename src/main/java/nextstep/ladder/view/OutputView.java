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
        System.out.println("\n사다리 결과");
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

    public static void printResult(String personName, List<Person> people, List<String> results) {
        if (personName.equals("all")) {
            printAllResult(people, results);
            return;
        }
        printIndivisualResult(people, results, personName);
    }

    private static void printIndivisualResult(List<Person> people, List<String> results, String personName) {
        Person person = people.stream()
                .filter(it -> it.getName().equals(personName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자입니다."));
        String wantedResult = results.get(person.getPosition());
        System.out.println(wantedResult);
    }

    private static void printAllResult(List<Person> people, List<String> results) {
        people.forEach(person -> {
            String wantedResult = results.get(person.getPosition());
            System.out.println(person.getName() + " : " + wantedResult);
        });
    }

}
