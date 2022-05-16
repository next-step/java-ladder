package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Point;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String UNIT_HORIZONTAL_LINE = "-";
    private static final String UNIT_VERTICAL_LINE = "|";

    private OutputView() {
    }

    public static void printParticipants(List<String> participantNames, int maxConnectionLineLength) {
        participantNames.forEach(name -> System.out.print(name + BLANK.repeat(maxConnectionLineLength - name.length())));
        System.out.println();
    }

    public static void printLine(List<Point> points, int maxConnectionLineLength) {
        points.stream().forEach(point -> {
            if (point.isLast(points.size())) {
                System.out.println(UNIT_VERTICAL_LINE);
                return;
            }
            if (point.isStraight() || point.isLeft()) {
                System.out.print(UNIT_VERTICAL_LINE + BLANK.repeat(maxConnectionLineLength));
                return;
            }
            if (point.isRight()) {
                System.out.print(UNIT_VERTICAL_LINE + UNIT_HORIZONTAL_LINE.repeat(maxConnectionLineLength));
                return;
            }
        });
        System.out.println();
    }

    public static void printLadder(Ladder ladder, int maxConnectionLineLength) {
        ladder.lines().forEach(line -> printLine(line.points(), maxConnectionLineLength));
    }
}
