package nextstep.ladder.domain.bridge;

import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BridgesTest {

    private Bridges createBridges(List<Bridge> bridges) {
        return new Bridges(bridges);
    }

    @ParameterizedTest
    @MethodSource("provideMoveRightBridges")
    @DisplayName("오른쪽으로 움직일 다리가 있는 경우")
    void moveRight(List<Bridge> rightBridges) {
        Bridges bridges = this.createBridges(rightBridges);
        Position position = bridges.movePosition(new Position(0));
        assertThat(position).isEqualTo(new Position(1));
    }

    private static Stream<Arguments> provideMoveRightBridges() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Bridge(true, 0)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideMoveLeftBridges")
    @DisplayName("왼쪽으로 움직일 다리가 있는 경우")
    void moveLeft(List<Bridge> leftBridges) {
        Bridges bridges = this.createBridges(leftBridges);
        Position position = bridges.movePosition(new Position(1));
        assertThat(position).isEqualTo(new Position(0));
    }

    private static Stream<Arguments> provideMoveLeftBridges() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Bridge(true, 0), new Bridge(false, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotMoveBridges")
    @DisplayName("양쪽으로 다리가 없는 경우")
    void moveNone(List<Bridge> notMoveBridges) {
        Bridges bridges = this.createBridges(notMoveBridges);
        Position position = bridges.movePosition(new Position(0));
        assertThat(position).isEqualTo(new Position(0));
    }

    private static Stream<Arguments> provideNotMoveBridges() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Bridge(false, 0), new Bridge(false, 1)))
        );
    }
}