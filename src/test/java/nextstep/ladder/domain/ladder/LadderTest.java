package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.point.strategy.SequentialConnectedPointGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(5, new SequentialConnectedPointGenerateStrategy(0));
    }

    @ParameterizedTest
    @DisplayName("왼쪽 사다리와 연결 지점이 겹치는 경우 변경한다")
    @MethodSource("param")
    void reArrangeConnectPointsTest(Ladder leftLadder, int changedConnectedPoint) {
        assertTrue(ladder.isConnected(0));

        ladder.reArrangeConnectPoints(leftLadder);

        assertFalse(ladder.isConnected(0));
        assertTrue(ladder.isConnected(changedConnectedPoint));
    }

    private static Stream<Arguments> param() {
        return Stream.of(
                Arguments.of(new Ladder(5, new SequentialConnectedPointGenerateStrategy(0)), 1),
                Arguments.of(new Ladder(5, new SequentialConnectedPointGenerateStrategy(1)), 2),
                Arguments.of(new Ladder(5, new SequentialConnectedPointGenerateStrategy(2)), 3),
                Arguments.of(new Ladder(5, new SequentialConnectedPointGenerateStrategy(3)), 4)
        );
    }
}