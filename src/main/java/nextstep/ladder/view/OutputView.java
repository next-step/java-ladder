package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Persons;

import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * Created by wyparks2@gmail.com on 2019-06-29
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class OutputView {
    private static final String PERSON_NAME_FORMAT = "%5s";
    private static final String EXECUTE_RESULT_MESSAGE = "실행결과";
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String HORIZONTAL_BLANK_LINE = "     ";

    public static void printResult(Persons persons, Ladder ladder) {
        printExecuteResultMessage();

        printPersonsName(persons);
        printLadder(ladder);
    }

    private static void printExecuteResultMessage() {
        out.println(EXECUTE_RESULT_MESSAGE);
        newLine();
    }

    private static void printPersonsName(Persons persons) {
        persons.stream()
                .map(Person::getName)
                .map(name -> String.format(PERSON_NAME_FORMAT, name))
                .forEach(out::print);

        newLine();
    }

    private static void newLine() {
        out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.stream()
                .map(OutputView::makeHorizontalLine)
                .forEach(out::println);
    }

    private static String makeHorizontalLine(Line line) {
        return line.stream()
                .map(point -> point ? VERTICAL_LINE + HORIZONTAL_LINE : VERTICAL_LINE + HORIZONTAL_BLANK_LINE)
                .collect(Collectors.joining());
    }
}
