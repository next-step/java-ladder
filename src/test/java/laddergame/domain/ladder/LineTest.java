package laddergame.domain.ladder;

import laddergame.domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    private static Stream<Arguments> provideBeforeAndAfterPosition() {
        return Stream.of(Arguments.of(new Position(1, 1), new Position(2, 2)),
                Arguments.of(new Position(2, 1), new Position(1, 2)),
                Arguments.of(new Position(3, 1), new Position(3, 2)));
    }

    @DisplayName("인원수에 맞게 다리를 생성한다.")
    @ParameterizedTest
    @MethodSource("provideNumberOfPlayerAndBridges")
    void createLine(int numberOfPlayer, List<Boolean> expectedConnection, List<Bridge> expectedResult) {
        FixedConnectGenerator fixedConnectGenerator = new FixedConnectGenerator(expectedConnection);

        Line line = new Line(1, numberOfPlayer, fixedConnectGenerator);

        assertThat(line.getBridges()).isEqualTo(expectedResult);
    }

    @DisplayName("한 라인의 연결 상태를 boolean 값으로 반환한다.")
    @Test
    void getLineStates() {
        Line line = new Line(1, 4, () -> true);
        assertThat(line.getLineStates()).isEqualTo(Arrays.asList(true, false, true));
    }

    @DisplayName("Position의 높이와 Line의 높이가 같은지 확인")
    @ParameterizedTest
    @CsvSource({"1, true", "2, false"})
    void isSameHeight(int height, boolean result) {
        Line line = new Line(1, 4, () -> true);
        Position position = new Position(1, height);
        assertThat(line.isSameHeight(position)).isEqualTo(result);
    }

    @DisplayName("인자로 받은 Position 의 높이와 열 번호를 보고 이동시킨다.")
    @ParameterizedTest
    @MethodSource("provideBeforeAndAfterPosition")
    void movePosition(Position before, Position after) {
        BridgeConnectGenerator bridgeConnectGenerator = new FixedConnectGenerator(Arrays.asList(true, false, false));
        Line line = new Line(1, 4, bridgeConnectGenerator);

        Position actualResult = line.movePosition(before);

        assertThat(actualResult).isEqualTo(after);
    }

    @DisplayName("인자로 받은 Position 의 열 번호가 없는 번호일 때 IllegalArgumentException throw.")
    @Test
    void moveWrongPosition() {
        BridgeConnectGenerator bridgeConnectGenerator = new FixedConnectGenerator(Arrays.asList(true, false, false));
        Position wrongPosition = new Position(5, 1);
        Line line = new Line(1, 4, bridgeConnectGenerator);

        assertThatThrownBy(() -> line.movePosition(wrongPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 위치 열 번호에 맞는 Bridge를 찾을 수 없습니다. - " + wrongPosition.getColumn());
    }
}