package nextstep.view;

import nextstep.domain.Line;
import nextstep.domain.Participants;
import nextstep.domain.Person;
import nextstep.domain.StringUtils;

import java.util.List;

public class OutputView {

    private static final String TRANSVERSE_BAR = "-----";
    private static final String EMPTY_BAR = "     ";
    private static final String PIPE = "|";
    private static final int PAD_SIZE = 6;

    private OutputView() {

    }

    public static void printExecuteResult(List<Person> persons, List<Line> lines) {
        System.out.println("실행결과");
        System.out.println();
        persons.stream()
                .map(person -> StringUtils.padLeft(person.getName(), PAD_SIZE))
                .forEach(OutputView::printPerson);
        System.out.println();
        lines.stream()
                .map(Line::getPoints)
                .forEach(OutputView::printLines);
    }

    private static void printPerson(String person) {
        System.out.print(person);
    }

    private static void printLines(List<Boolean> points) {
        System.out.print(EMPTY_BAR);
        System.out.print(PIPE);
        points.forEach(OutputView::printLine);
        System.out.println();
    }

    private static void printLine(Boolean point) {
        System.out.print(point ? TRANSVERSE_BAR : EMPTY_BAR);
        System.out.print(PIPE);
    }

}
