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
import static org.assertj.core.api.Assertions.in;

class LineTest {
    private static Stream<Arguments> provideNumberOfPlayerAndBridges() {
        return Stream.of(
                Arguments.of(1, Arrays.asList(false), createBridges(Arrays.asList(false))),
                Arguments.of(2, Arrays.asList(true), createBridges(Arrays.asList(true))),
                Arguments.of(3, Arrays.asList(false, true), createBridges(Arrays.asList(false, true))));
    }

    private static List<Bridge> createBridges(List<Boolean> connections) {
        return IntStream.rangeClosed(1, connections.size())
                .mapToObj(column -> new Bridge(connections.get(column - 1), column))
                .collect(Collectors.toList());

    }

    @DisplayName("인원수에 맞게 다리를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideNumberOfPlayerAndBridges")
    void createLine(int numberOfPlayer, List<Boolean> expectedConnection, List<Bridge> expectedResult) {
        FixedConnectGenerator fixedConnectGenerator = new FixedConnectGenerator(expectedConnection);

        Line line = new Line(numberOfPlayer, fixedConnectGenerator);

        assertThat(line.getBridges()).isEqualTo(expectedResult);
    }

    @DisplayName("한 라인의 연결 상태를 boolean 값으로 반환한다.")
    @Test
    void getLineStates() {
        Line line = new Line(4, () -> true);
        assertThat(line.getLineStates()).isEqualTo(Arrays.asList(true, false, true));
    }
}