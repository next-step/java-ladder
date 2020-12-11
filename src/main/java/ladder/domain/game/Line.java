package ladder.domain.game;

import ladder.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created By mand2 on 2020-12-04.
 */
public class Line {

    public static final String MESSAGE_BRIDGES_DUPLICATED = "사다리의 라인이 겹쳐있으면 안됩니다.";

    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line of(List<Boolean> bridges) {
        validation(bridges);
        return new Line(
                bridges.stream()
                        .map(Bridge::of)
                        .collect(Collectors.toList()));
    }

    private static void validation(List<Boolean> bridges) {
        // true true 안됨
        IntStream.range(0, bridges.size() - 1)
                .filter(i -> bridges.get(i) && bridges.get(i + 1))
                .findAny()
                .ifPresent((i) -> {
                    throw new IllegalArgumentException(MESSAGE_BRIDGES_DUPLICATED);
                });
    }

    public static Line of(int participantNum, ConnectionStrategy connectionStrategy) {
        return of(init(participantNum, connectionStrategy));
    }

    private static List<Boolean> init(int participantNum, ConnectionStrategy connectionStrategy) {
        List<Boolean> bridges = new ArrayList<>();

        for (int i = 0; i < participantNum; i++) {
            addBridge(bridges, connectionStrategy);
        }

        return bridges;
    }

    private static void addBridge(List<Boolean> bridges, ConnectionStrategy connectionStrategy) {
        if (bridges.isEmpty()) {
            addFirst(bridges);
            return;
        }
        addNext(bridges, connectionStrategy);
    }

    private static void addFirst(List<Boolean> bridges) {
        bridges.add(false);
    }

    private static void addNext(List<Boolean> bridges, ConnectionStrategy connectionStrategy) {
        bridges.add(hasConnected(bridges, connectionStrategy));
    }

    private static Boolean hasConnected(List<Boolean> bridges, ConnectionStrategy connectionStrategy) {
        return !bridges.get(bridges.size() - 1) && connectionStrategy.hasConnected();
    }

    public List<Boolean> getLine() {
        return this.bridges.stream()
                .map(Bridge::hasConnected)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public int move(int index) {
        if (moveLeft(index)) { // 현재 위치 -> 연결되었을 때
            return index - 1;
        }

        if (moveRight(index)) {
            return index + 1;
        }

        return index;
    }

    private boolean moveLeft(int index) {
        return indexOf(index).hasConnected();
    }

    private boolean moveRight(int index) {
        return index < this.bridges.size() - 1
                && indexOf(index + 1).hasConnected();
    }

    private Bridge indexOf(int index) {
        return this.bridges.get(index);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(bridges, line.bridges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bridges);
    }
}
