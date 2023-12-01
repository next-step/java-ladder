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

    /**
     * 참가자의 위치를 i라고 한다면 사다리 상태는 i-1, i 2개를 확인해야 합니다.
     * 1. i-1 이 연결되어 있다면 참가자의 위치는 i-1 이 됩니다.
     * 2. i 가 연결되어 있다면 참가자의 위치는 i+1 이 됩니다.
     * 3. 둘 다 연결되어 있지 않다면 참가자의 위치는 i가 됩니다.
     */
    public void go(Participator participator) {
        int location = participator.getLocation();
        if (isLeftLadderConnected(line, location)) {
            participator.goLeft();
            return;
        }

        if (isRightLadderConnected(line, location)) {
            participator.goRight();
        }
    }

    private static void applyWidthCondition(List<WidthStatus> line, int currentLocation) {
        if (isConnectedContinuously(line, currentLocation)) {
            line.set(currentLocation, WidthStatus.notConnected);
        }
    }

    private static boolean isConnectedContinuously(List<WidthStatus> line, int location) {
        return isConnected(line, location - 1) && isConnected(line, location);
    }

    private boolean isLeftLadderConnected(List<WidthStatus> line, int location) {
        return location != 0 && isConnected(line, location - 1);
    }

    private boolean isRightLadderConnected(List<WidthStatus> line, int location) {
        return location != line.size() && isConnected(line, location);
    }

    private static boolean isConnected(List<WidthStatus> line, int location) {
        return line.get(location).equals(WidthStatus.connected);
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
