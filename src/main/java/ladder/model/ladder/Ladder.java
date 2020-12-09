package ladder.model.ladder;

import ladder.model.group.Users;
import ladder.model.move.Point;
import utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final static int LADDER_MIN_LIMIT = 0;
    private final static int LINE_ITEM_VARIABLE = 1;
    private final static String LADDER_SIZE_ERROR_MESSAGE = "올바른 사다리 높이를 입력해주세요";

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder of(String ladderSize, int userSize) {
        validateLadderSize(ladderSize);

        int numberOfItems = userSize - LINE_ITEM_VARIABLE;

        List<Line> lines = IntStream.range(0, StringUtils.stringToInt(ladderSize))
                .mapToObj(column -> makeLineItems(numberOfItems, column))
                .map(Line::from)
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    public Map<String, Point> getResults(Users users) {
        Map<String, Point> results = new LinkedHashMap<>();

        List<Point> userPoints = users.getUserPoint();

        IntStream.range(0, userPoints.size())
                .forEach(idx -> results.put(users.findUserNameByIdx(idx), getResult(userPoints.get(idx))));

        return results;
    }

    private Point getResult(Point startPoint) {
        return lines.stream()
                .reduce(startPoint, (point, line) -> line.movePoint(point), (x, y) -> y);
    }

    public int size() {
        return lines.size();
    }

    private static List<Bridge> makeLineItems(int numberOfItems, int column) {
        List<Bridge> bridges = new ArrayList<>();
        List<Point> bridgePoints = IntStream.rangeClosed(1, numberOfItems)
                .mapToObj(idx -> Point.bridgePoint(idx, column))
                .collect(Collectors.toList());

        bridges.add(Bridge.createRandomBridge(bridgePoints.get(0)));

        IntStream.range(1, numberOfItems)
                .forEach(idx -> bridges.add(makeBridge(bridgePoints.get(idx), bridges.get(idx - 1))));

        return bridges;
    }

    private static Bridge makeBridge(Point point, Bridge previousBridges) {
        if (previousBridges.isMovable()) {
            return Bridge.createNonMovableBridge(point);
        }

        return Bridge.createRandomBridge(point);
    }

    private static void validateLadderSize(String size) {
        if (!StringUtils.isPositiveNumber(size)) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }

        int ladderSize = StringUtils.stringToInt(size);

        if (ladderSize <= LADDER_MIN_LIMIT) {
            throw new IllegalArgumentException(LADDER_SIZE_ERROR_MESSAGE);
        }
    }

    public List<String> getLadder() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.toList());
    }
}