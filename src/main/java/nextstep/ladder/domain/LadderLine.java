package nextstep.ladder.domain;

import java.util.*;

public class LadderLine {
    public static final String INVALID_LINE_SIZE_MESSAGE = "사다리 라인의 크기는 1 이상이어야 합니다.";
    public static final String INVALID_PAIR_MESSAGE = "사다리 연결 정보가 일치하지 않습니다.";
    public static final String FIRST_BRIDGE_CANNOT_LEFT_CONNECTED = "첫번째 사다리의 왼쪽은 연결되어 있으면 안됩니다.";
    public static final String LAST_BRIDGE_CANNOT_RIGHT_CONNECTED = "마지막 사다리의 오른쪽은 연결되어 있으면 안됩니다.";

    private final List<Bridge> bridges;

    public LadderLine(List<Bridge> lines) {
        valid(lines);
        this.bridges = Collections.unmodifiableList(lines);
    }

    private void valid(List<Bridge> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }

        validEdge(lines);

        for (int i = 0; i < lines.size() - 1; i++) {
            validPairValue(lines.get(i), lines.get(i + 1));
        }
    }

    private static void validEdge(List<Bridge> lines) {
        if (lines.get(0).notValidAsFirst()) {
            throw new IllegalArgumentException(FIRST_BRIDGE_CANNOT_LEFT_CONNECTED);
        }

        if (lines.get(lines.size() - 1).notValidAsLast()) {
            throw new IllegalArgumentException(LAST_BRIDGE_CANNOT_RIGHT_CONNECTED);
        }
    }

    private static void validPairValue(Bridge current, Bridge next) {
        if (current.notMatchWithNext(next)) {
            throw new IllegalArgumentException(INVALID_PAIR_MESSAGE);
        }
    }

    public List<Bridge> asList() {
        return bridges;
    }

    public boolean sameSize(LadderLine ladderLine2) {
        return this.bridges.size() == ladderLine2.bridges.size();
    }

    public int nextPosition(int position) {
        Direction direction = bridges.get(position).nextDirection();

        if (direction == Direction.LEFT) {
            return (position - 1);
        }

        if (direction == Direction.RIGHT) {
            return (position + 1);
        }

        return position;
    }

    public static LadderLine generate(int size) {
        validSize(size);

        Random random = new Random();
        List<Bridge> result = new ArrayList<>();
        Bridge prev = generateFirst(random);
        result.add(prev);

        for (int i = 1; i < size - 1; i++) {
            Bridge next = generateNext(prev, random);
            result.add(next);
            prev = next;
        }

        Bridge last = new Bridge(prev.isRightConnected(), false);
        result.add(last);

        return new LadderLine(result);
    }

    private static void validSize(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(INVALID_LINE_SIZE_MESSAGE);
        }
    }

    private static Bridge generateFirst(Random random) {
        return new Bridge(false, random.nextBoolean());
    }

    private static Bridge generateNext(Bridge prev, Random random) {
        if (prev.nextDirection() == Direction.RIGHT) {
            return new Bridge(true, false);
        }

        return new Bridge(false, random.nextBoolean());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(bridges, that.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bridges);
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "bridges=" + bridges +
                '}';
    }
}
