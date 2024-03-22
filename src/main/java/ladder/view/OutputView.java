package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;

public class OutputView {

    private static final String LADDER_HEADER_MESSAGE = "실행결과\n";
    private static final String FIRST_PARTICIPANT_COLUMN = "    |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String NO_HORIZONTAL_LINE = "     |";
    private static final String NAME_FORMAT = "%5s";
    private static final String NAME_DELIMITER = " ";
    private static final int FIRST_HORIZONTAL_COLUMN_INDEX = 1;
    private static final int HORIZONTAL_COLUMN_GAP = 2;

    public void printLine() {
        System.out.println();
    }

    public void printLadder(Ladder ladder, List<Name> names) {
        System.out.println(LADDER_HEADER_MESSAGE);
        printNames(names);

        List<Line> lines = ladder.lines();
        lines.forEach(this::printLine);
    }

    private void printNames(List<Name> names) {
        String strNames = names.stream()
            .map(Name::value)
            .map(name -> String.format(NAME_FORMAT, name))
            .collect(Collectors.joining(NAME_DELIMITER));
        System.out.println(strNames);
    }

    private void printLine(Line line) {
        List<Boolean> points = line.points();
        System.out.print(FIRST_PARTICIPANT_COLUMN);
        for (int i = FIRST_HORIZONTAL_COLUMN_INDEX; i < points.size(); i += HORIZONTAL_COLUMN_GAP) {
            printPoint(points.get(i));
        }
        printLine();
    }

    private void printPoint(Boolean point) {
        if (point) {
            System.out.print(HORIZONTAL_LINE);
            return;
        }
        System.out.print(NO_HORIZONTAL_LINE);
    }
}
