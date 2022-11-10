package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.Points;

import java.util.stream.Collectors;

public class ResultView extends View {
    private static final String LADDER_INIT_MESSAGE = "사다리 결과";
    private static final String RESULT_INIT_MESSAGE = "실행 결과";
    private static final String LENGTH_FORMAT_PREFIX = "%-";
    private static final String LENGTH_FORMAT_SUFFIX = "s ";
    private static final String HORIZONTAL_ROAD = "-";
    private static final String EMPTY_HORIZONTAL_ROAD = " ";
    private static final String VERTICAL_ROAD = "|";
    private static final String RESULT_FORMAT = "%s : %s%n";


    public void printLadderInitMessage() {
        System.out.println(LADDER_INIT_MESSAGE);
        printEmptyLine();
    }

    public void printNames(Points points, int nameMaxLength) {
        String printFormat = getStringLengthFormat(nameMaxLength);
        points.points().forEach(point -> System.out.printf(printFormat, point.name()));
        printEmptyLine();
    }

    public void printLadder(Ladder ladder, int nameMaxLength) {
        ladder.getLines().stream()
                .map(line -> lineConvertString(line, nameMaxLength))
                .forEach(System.out::println);
    }

    public void printResult(Points printTargetPoints, Points winningItems) {
        System.out.println(RESULT_INIT_MESSAGE);
        printTargetPoints.points()
                .forEach(point -> {
                    Point winningPoint = winningItems.get(point.location());
                    System.out.printf(RESULT_FORMAT, point.name(), winningPoint.name());
                });
        this.printEmptyLine();
    }

    private String getStringLengthFormat(int lengthPerString) {
        return LENGTH_FORMAT_PREFIX + lengthPerString + LENGTH_FORMAT_SUFFIX;
    }

    private String lineConvertString(Line line, int nameMaxLength) {
        String lineString = line.line().stream()
                .map(point -> pointConvertString(point, nameMaxLength))
                .collect(Collectors.joining(VERTICAL_ROAD));
        return VERTICAL_ROAD + lineString + VERTICAL_ROAD;
    }

    private String pointConvertString(Boolean point, int nameMaxLength) {
        if (Boolean.TRUE.equals(point)) {
            return HORIZONTAL_ROAD.repeat(nameMaxLength);
        }
        return EMPTY_HORIZONTAL_ROAD.repeat(nameMaxLength);
    }
}
