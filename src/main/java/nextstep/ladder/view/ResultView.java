package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String HEIGHT_UNIT = "|";
    private static final String VERTICAL_LINE_UNIT = "-";
    private static final String VERTICAL_EMPTY_UNIT = " ";
    private static final String RESULT_LADDER = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";


    public static void printLadder(Persons persons, Ladders ladders, Results results) {
        System.out.println(RESULT_LADDER);
        int lengthCount = persons.getPersons().stream()
                .map(person -> person.getLength())
                .max(Integer::compareTo)
                .orElse(0) + 2;
        printPersons(lengthCount, persons);
        printLadder(lengthCount, ladders);
        printResult(lengthCount, results);
    }

    private static void printResult(int maxLength, Results results) {
        results.getResults().forEach(result -> System.out.print(resultText(maxLength, result)));
        System.out.println();
    }

    private static String resultText(int maxLength, Result result) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - result.getLength())
                .collect(Collectors.joining()) + result;
    }

    private static void printPersons(int maxLength, Persons persons) {
        persons.getPersons().forEach(person -> System.out.print(personText(maxLength, person)));
        System.out.println();
    }

    private static String personText(int maxLength, Person person) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - person.getLength())
                .collect(Collectors.joining()) + person;
    }

    private static void printLadder(int maxLength, Ladders ladders) {
        printHeight(maxLength, ladders.getLadders());
    }

    private static void printHeight(int maxLength, List<Ladder> heights) {
        for (Ladder height : heights) {
            printVerticals(maxLength, height.getLines());
            System.out.println();
        }
    }

    private static void printVerticals(int maxLength, List<Boolean> vertical) {
        System.out.print(startLadder(maxLength));
        vertical.stream()
                .map(isLine -> isLine ? createVertical(maxLength) : createEmpty(maxLength))
                .forEach(unit -> printVertical(unit));
    }

    private static void printVertical(String unit) {
        System.out.print(unit);
    }

    private static String startLadder(int maxLength) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - 1)
                .collect(Collectors.joining()) + HEIGHT_UNIT;
    }

    private static String createVertical(int maxLength) {
        return Stream.generate(() -> VERTICAL_LINE_UNIT)
                .limit(maxLength - 1)
                .collect(Collectors.joining()) + HEIGHT_UNIT;
    }

    private static String createEmpty(int maxLength) {
        return Stream.generate(() -> VERTICAL_EMPTY_UNIT)
                .limit(maxLength - 1)
                .collect(Collectors.joining()) + HEIGHT_UNIT;
    }


    public static void printGameResultAll(List<PersonResult> personResults) {
        System.out.println(RESULT_MESSAGE);
        printAll(personResults);
    }

    private static void printAll(List<PersonResult> personResults) {

        for (PersonResult personResult : personResults) {
            System.out.println(personResult.getPerson() + " : " + personResult.getResult());
        }
    }

    public static void printGameResult(PersonResult personResult) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(personResult.getResult());
    }
}
