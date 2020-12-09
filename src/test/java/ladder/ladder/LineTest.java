package ladder.ladder;

import ladder.model.ladder.Bridge;
import ladder.model.ladder.Line;
import ladder.model.move.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    private final static List<Bridge> MOVABLE_BRIDGE = IntStream.rangeClosed(1,3)
            .mapToObj(idx -> Bridge.createMovableBridge(Point.bridgePoint(idx,0)))
            .collect(Collectors.toList());

    private final static List<Bridge> NON_MOVABLE_BRIDGE = IntStream.rangeClosed(1,3)
            .mapToObj(idx -> Bridge.createNonMovableBridge(Point.bridgePoint(idx,0)))
            .collect(Collectors.toList());

    @ParameterizedTest
    @MethodSource("generateErrorLadderItems")
    public void 비정상_사다리(List<Bridge> bridges) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.from(bridges))
                .withMessageMatching("올바르지 못한 라인입니다.");
    }

    @ParameterizedTest
    @MethodSource("generateLadderItems")
    public void 정상_사다리(List<Bridge> bridges) {
        assertThat(Line.from(bridges));
    }

    private static Stream<List<Bridge>> generateErrorLadderItems() {
        return Stream.of(
                Arrays.asList(MOVABLE_BRIDGE.get(0), MOVABLE_BRIDGE.get(1)),
                Arrays.asList(NON_MOVABLE_BRIDGE.get(0), MOVABLE_BRIDGE.get(1), MOVABLE_BRIDGE.get(2)),
                Arrays.asList(MOVABLE_BRIDGE.get(0), MOVABLE_BRIDGE.get(1), NON_MOVABLE_BRIDGE.get(2))
        );
    }

    private static Stream<List<Bridge>> generateLadderItems() {
        return Stream.of(
                Arrays.asList(MOVABLE_BRIDGE.get(0), NON_MOVABLE_BRIDGE.get(1)),
                Arrays.asList(NON_MOVABLE_BRIDGE.get(0), MOVABLE_BRIDGE.get(1)),
                Arrays.asList(NON_MOVABLE_BRIDGE.get(0), NON_MOVABLE_BRIDGE.get(1))
        );
    }

}
