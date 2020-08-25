package nextstep.mission;

import java.util.List;
import java.util.stream.Collectors;

public class ResultViewer {

    public static final String LINE = "-----";
    public static final String NO_LINE = "     ";
    public static final String LINE_SHAPE = "|";

    public static final String lineToWrite(Line line) {
        List<Boolean> points = line.getPoints();
        return points.stream()
                .limit(points.size())
                .map(value -> value ? LINE : NO_LINE)
                .collect(Collectors.joining(LINE_SHAPE)) + LINE_SHAPE;
    }
}