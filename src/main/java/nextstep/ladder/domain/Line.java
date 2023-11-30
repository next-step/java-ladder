package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<WidthStatus> line;

    public Line(List<WidthStatus> line) {
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

    public boolean isConnected(int location) {
        return line.get(location).equals(WidthStatus.connected);
    }

    public int getSize() {
        return line.size();
    }

    private static void applyWidthCondition(List<WidthStatus> line, int currentLocation) {
        if (isConnectedContinuously(line, currentLocation)) {
            line.set(currentLocation, WidthStatus.notConnected);
        }
    }

    private static boolean isConnectedContinuously(List<WidthStatus> line, int location) {
        return line.get(location - 1) == WidthStatus.connected && line.get(location) == WidthStatus.connected;
    }

    public List<WidthStatus> getLine() {
        return Collections.unmodifiableList(line);
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
