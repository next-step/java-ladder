package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.People;
import ladder.domain.Point;

import java.util.List;

public class ResultView {
    private static final int NAME_MAX_LENGTH = 6;
    private static final String LADDER_LINE = "|     ";
    private static final String LADDER_POINT = "|-----";
    private static final String INTERVAL = " ";

    private ResultView() {

    }

    public static void print(Lines lines, People people) {
        printPeople(people.getPeople());
        printAllLines(lines.getLadderLines());
    }

    private static void printPeople(List<String> people) {
        people.stream()
                .filter(person -> person.length() < NAME_MAX_LENGTH)
                .forEach(person ->
                        System.out.print(person + printEmptyForCorrection(NAME_MAX_LENGTH - person.length())));
        System.out.println();
    }

    private static String printEmptyForCorrection(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(INTERVAL);
        }
        return stringBuilder.toString();
    }

    private static void printAllLines(List<Line> lines) {
        for (Line line : lines) {
            printLines(line.getPoints());
            System.out.println();
        }
    }

    private static void printLines(List<Point> ladderPoints) {
        for (Point ladderPoint : ladderPoints) {
            System.out.print(printPoint(ladderPoint));
        }
    }

    private static String printPoint(Point point) {
        if (point.getType()) {
            return LADDER_POINT;
        }
        return LADDER_LINE;
    }
}
