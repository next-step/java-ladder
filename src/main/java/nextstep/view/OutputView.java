package nextstep.view;

import nextstep.domain.Line;
import nextstep.domain.Person;
import nextstep.domain.PersonValidator.Constants;
import nextstep.domain.StringUtils;

import java.util.List;

public class OutputView {

    public static final String TRANSVERSE_BAR = "-----";
    public static final String EMPTY_BAR = "     ";
    public static final String PIPE = "|";

    private OutputView() {

    }

    public static void printExecuteResult(List<Person> persons, List<Line> lines) {
        System.out.println("실행결과");
        System.out.println();
        persons.stream()
                .map(person -> StringUtils.padRight(person.getName(), Constants.MAX_LENGTH))
                .forEach(OutputView::printPerson);
        System.out.println();
        lines.stream()
                .map(line -> line.getPoints())
                .forEach(OutputView::printLines);
    }

    private static void printPerson(String person) {
        System.out.print(person);
    }

    private static void printLines(List<Boolean> points) {
        System.out.print(EMPTY_BAR);
        System.out.print(PIPE);
        points.stream()
                .forEach(OutputView::printLine);
        System.out.println();
    }

    private static void printLine(Boolean point) {
        System.out.print(point ? TRANSVERSE_BAR : EMPTY_BAR);
        System.out.print(PIPE);
    }

}
