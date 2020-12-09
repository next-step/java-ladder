package ladder.model.ladder;

import ladder.model.move.Point;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Line {
    private final static String LINE_ERROR_MESSAGE = "올바르지 못한 라인입니다.";
    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line from(List<Bridge> bridges) {
        validateLine(bridges);
        return new Line(bridges);
    }

    public Point movePoint(Point point){
        Optional<Bridge> optionalBridge = getBridge(point);

        if(optionalBridge.isPresent()){
            point = point.move(optionalBridge.get().directionByUser(point));
        }

        point = point.moveDown();

        return point;
    }

    private Optional<Bridge> getBridge(Point point){
        return bridges.stream()
                .filter(bridge -> bridge.isCross(point))
                .filter(Bridge::isMovable)
                .findFirst();
    }

    private static void validateLine(List<Bridge> bridges) {
        if (bridges.size() == 1) {
           return;
        }

        boolean hasInvalidLadderItem = IntStream.range(0, bridges.size() - 1)
                .mapToObj(idx -> window(idx, bridges))
                .reduce((x, y) -> x || y)
                .orElse(Boolean.TRUE);

        if (hasInvalidLadderItem) {
            throw new IllegalArgumentException(LINE_ERROR_MESSAGE);
        }
    }

    private static boolean window(int idx, List<Bridge> bridges) {
        Bridge now = bridges.get(idx);
        Bridge next = bridges.get(idx + 1);

        return now.isMovable() && next.isMovable();
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder(LadderItem.VERTICAL.getItem());

        bridges.stream()
                .map(this::partOfLine)
                .forEach(line::append);

        return line.toString();
    }

    private String partOfLine(Bridge bridge) {
        return bridge.toString() + LadderItem.VERTICAL.getItem();
    }
}
