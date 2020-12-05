package ladder;

import ladder.model.Bridge;
import ladder.model.Line;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

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
                Arrays.asList(Bridge.createMovableBridge(0), Bridge.createMovableBridge(1)),
                Arrays.asList(Bridge.createNonMovableBridge(0), Bridge.createMovableBridge(1), Bridge.createMovableBridge(2)),
                Arrays.asList(Bridge.createMovableBridge(0), Bridge.createMovableBridge(1), Bridge.createNonMovableBridge(2))
        );
    }

    private static Stream<List<Bridge>> generateLadderItems() {
        return Stream.of(
                Arrays.asList(Bridge.createMovableBridge(0), Bridge.createNonMovableBridge(1)),
                Arrays.asList(Bridge.createNonMovableBridge(0), Bridge.createMovableBridge(1)),
                Arrays.asList(Bridge.createNonMovableBridge(0), Bridge.createNonMovableBridge(1))
        );
    }

}
