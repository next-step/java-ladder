package ladder.view;

import ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView extends View {
    private final String RESULT_INIT_MESSAGE = "실행결과";
    private final String NAME_PRINT_FORMAT_PREFIX = "%-";
    private final String NAME_PRINT_FORMAT_SUFFIX = "s ";
    private final String HORIZONTAL_ROAD = "-";
    private final String EMPTY_HORIZONTAL_ROAD = " ";
    private final String VERTICAL_ROAD = "|";

    public void printResultInitMessage() {
        System.out.println(RESULT_INIT_MESSAGE);
        printEmptyLine();
    }

    public void printParticipantNames(List<String> participantNames, int namesMaxLength) {
        String printFormat = getNamesPrintFormat(namesMaxLength);
        participantNames.forEach(participantName -> System.out.printf(printFormat, participantName));
        printEmptyLine();
    }

    private String getNamesPrintFormat(int namesMaxLength) {
        return NAME_PRINT_FORMAT_PREFIX + namesMaxLength + NAME_PRINT_FORMAT_SUFFIX;
    }

    public void printLadder(List<Line> lines, int namesMaxLength) {
        lines.stream()
                .map(line -> lineConvertString(line, namesMaxLength))
                .forEach(System.out::println);
    }

    private String lineConvertString(Line line, int namesMaxLength) {
        String lineString = line.getPoints().stream()
                .map(point -> point ? HORIZONTAL_ROAD.repeat(namesMaxLength) : EMPTY_HORIZONTAL_ROAD.repeat(namesMaxLength))
                .collect(Collectors.joining(VERTICAL_ROAD));
        return VERTICAL_ROAD + lineString + VERTICAL_ROAD;
    }
}
