package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.People;

public class ResultView {

    private static final String NAME_PADDING_FORMAT = "%6s";
    private static final String HORIZONTAL_LINE_FORMAT = "%5s";
    private static final String EMPTY_TEXT_REGAX = "\\s";
    private static final String HORIZONTAL_LINE = "-";
    private static final String VERTICAL_LINE = "|";

    public static void printResult(People people, Ladder ladder) {
        printResultTitle();
        printNames(people);
        printNewLine();
        printLadder(ladder);
    }

    private static void printResultTitle() {
        System.out.println("실행결과");
    }

    private static void printNames(People people) {
        people.people().forEach(persone -> {
            String paddedName = String.format(NAME_PADDING_FORMAT, persone.name());
            System.out.print(paddedName);
        });
    }

    private static void printNewLine() {
        System.out.print("\n");
    }

    private static void printLadder(Ladder ladder) {
        String emptyHorizontalLineMark = String.format(HORIZONTAL_LINE_FORMAT, "");
        String horizontalLineMark = String.format(HORIZONTAL_LINE_FORMAT, "")
            .replaceAll(EMPTY_TEXT_REGAX, HORIZONTAL_LINE);

        ladder.lines().forEach(line -> {
            System.out.print(emptyHorizontalLineMark);
            line.points().points().forEach(point -> {
                System.out.print(VERTICAL_LINE);
                if (point.isTrue()) {
                    System.out.print(horizontalLineMark);
                }
                if (point.isFalse()) {
                    System.out.print(emptyHorizontalLineMark);
                }
            });
            System.out.println(VERTICAL_LINE);
        });
    }

}
