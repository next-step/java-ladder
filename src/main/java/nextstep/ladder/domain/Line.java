package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<WidthStatus> line;

    private Line(List<WidthStatus> line) {
        this.line = line;
    }

    public static Line makeLine(int participatorCount, WidthMaker widthMaker) {
        int widthCount = participatorCount - 1;
        List<WidthStatus> line = IntStream.range(0, widthCount).boxed()
                .map(num -> WidthStatus.of(widthMaker.hasConnectCondition()))
                .collect(Collectors.toList());

        for (int i = 1; i < widthCount; i++) {
            applyWidthCondition(line, i);
        }

        return new Line(line);
    }

    private static void applyWidthCondition(List<WidthStatus> line, int i) {
        if (line.get(i - 1) == WidthStatus.connected && line.get(i) == WidthStatus.connected) {
            line.set(i, WidthStatus.notConnected);
        }
    }

    public List<WidthStatus> getLine() {
        return line;
    }

    @Override
    public String toString() {
        String prefix = "     |";
        String lineString = line.stream().map(status -> {
            if (status == WidthStatus.connected) {
                return "-----|";
            }
            return "     |";
        }).collect(Collectors.joining());

        return prefix + lineString;
    }
}
