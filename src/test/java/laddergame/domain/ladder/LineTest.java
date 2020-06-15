package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    private static Stream<Arguments> provideNumberOfPlayerAndBridges() {
        return Stream.of(Arguments.of(1, createBridges(1)),
                Arguments.of(2, createBridges(2)),
                Arguments.of(3, createBridges(3)));
    }

    private static List<Bridge> createBridges(int numberOfPlayer) {
        if (numberOfPlayer == 1) {
            return Arrays.asList(Bridge.createNotLinkedBridge(1));
        }

        List<Bridge> bridges = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayer / 2; i++) {
            bridges.add(Bridge.createRightBridge(i));
            bridges.add(Bridge.createLeftBridge(i + 1));
        }

        if (numberOfPlayer % 2 == 1) {
            bridges.add(Bridge.createNotLinkedBridge(numberOfPlayer));
        }

        return bridges;
    }

    @DisplayName("인원수에 맞게 다리를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideNumberOfPlayerAndBridges")
    void createLine(int numberOfPlayer, List<Bridge> expectedResult) {
        Line line = new Line(numberOfPlayer, () -> true);
        assertThat(line.getBridges()).isEqualTo(expectedResult);
    }

    @DisplayName("한 라인의 연결 상태를 boolean 값으로 반환한다.")
    @Test
    void getLineStates() {
        Line line = new Line(4, () -> true);
        assertThat(line.getLineStates()).isEqualTo(Arrays.asList(true, false, true));
    }
}