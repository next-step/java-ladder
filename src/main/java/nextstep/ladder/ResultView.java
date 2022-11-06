package nextstep.ladder;

import java.util.List;

public class ResultView {
    private static final String NAME_FORMAT = "%6s";
    private static final String NOT_CONNECTED = "     |";
    private static final String CONNECTED = "-----|";

    public static void printNames(List<Name> names) {
        names.forEach(name -> System.out.printf(NAME_FORMAT, name.getName()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(NOT_CONNECTED);
        for (int i = 0; i < line.size(); i++) {
            if (line.connected(i)) {
                System.out.print(CONNECTED);
            } else {
                System.out.print(NOT_CONNECTED);
            }
        }
        System.out.println();
    }
}
