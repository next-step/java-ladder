package nextstep.ladder.domain.point;

import nextstep.ladder.domain.point.strategy.ConnectedPointGenerateStrategy;
import nextstep.ladder.domain.point.strategy.SequentialConnectedPointGenerateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ConnectedPointsTest {

    private ConnectedPoints connectedPoints;

    @BeforeEach
    void setUp() {
        connectedPoints = new ConnectedPoints(5, new SequentialConnectedPointGenerateStrategy(0));
    }

    @Test
    @DisplayName("연결여부를 리턴한다")
    void isConnectedTest() {
        assertTrue(connectedPoints.isConnected(0));

        assertFalse(connectedPoints.isConnected(1));
        assertFalse(connectedPoints.isConnected(2));
        assertFalse(connectedPoints.isConnected(3));
        assertFalse(connectedPoints.isConnected(4));
    }

    @Test
    @DisplayName("연결을 해제한다")
    void disConnectTest() {
        assertTrue(connectedPoints.isConnected(0));

        connectedPoints.disConnect(0);

        assertFalse(connectedPoints.isConnected(0));
    }

    @Test
    @DisplayName("연결지점 갯수를 리턴한다")
    void connectedCountTest() {
        assertEquals(1, connectedPoints.connectedCount());
    }

    @ParameterizedTest
    @DisplayName("연결 포인트와 겹치지 않는 곳으로 연결한다")
    @MethodSource("param")
    void connectNotDuplicatedTest(int ladderHeight, ConnectedPointGenerateStrategy strategy, int changedPoint) {
        assertTrue(this.connectedPoints.isConnected(0));

        ConnectedPoints leftConnectedPoints = new ConnectedPoints(ladderHeight, strategy);
        this.connectedPoints.connectNotDuplicated(leftConnectedPoints);
        assertTrue(this.connectedPoints.isConnected(changedPoint));
    }

    private static Stream<Arguments> param() {
        return Stream.of(
                Arguments.of(5, new SequentialConnectedPointGenerateStrategy(0), 1),
                Arguments.of(5, new SequentialConnectedPointGenerateStrategy(1), 2),
                Arguments.of(5, new SequentialConnectedPointGenerateStrategy(2), 3),
                Arguments.of(5, new SequentialConnectedPointGenerateStrategy(3), 4)
        );
    }

}