package nextstep.view;

import nextstep.app.LadderResults;
import nextstep.domain.*;

import java.util.List;

public class OutputView {

    private static final String TRANSVERSE_BAR = "-----";
    private static final String EMPTY_BAR = "     ";
    private static final String PIPE = "|";
    private static final int PAD_SIZE = 6;

    private OutputView() {

    }

    public static void printLadder(Participants persons, LadderGameManager lines, LadderResults ladderResults) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();
        persons.getPersons().stream()
                .map(person -> StringUtils.padLeft(person.getName(), PAD_SIZE))
                .forEach(OutputView::printPerson);
        System.out.println();
        lines.getLines().stream()
                .map(Line::getPoints)
                .forEach(OutputView::printLines);
        ladderResults.getLadderResults().stream()
                .map(person -> StringUtils.padLeft(person.getResult(), PAD_SIZE))
                .forEach(OutputView::printPerson);
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
