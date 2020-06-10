package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    private static Stream<Arguments> providePlayersAndExpectResult() {
        return Stream.of(Arguments.of(1, Collections.EMPTY_LIST),
                Arguments.of(2, Arrays.asList(Bridge.createFirstBrige(true))),
                Arguments.of(3, Arrays.asList(Bridge.createFirstBrige(true), Bridge.createFirstBrige(false))));
    }

    @DisplayName("사다리의 한 라인을 참가자 수 보다 하나 작게 생성한다.")
    @ParameterizedTest
    @MethodSource("providePlayersAndExpectResult")
    void generateLine(int numberOfPlayer, List<Bridge> bridges) {
        Line line = new Line(numberOfPlayer, numberOfPlayer1 -> IntStream.range(0, numberOfPlayer1 - 1)
                .mapToObj(number -> Bridge.createFirstBrige(number % 2 == 0))
                .collect(Collectors.toList()));

        assertThat(line.getLine().size()).isEqualTo(numberOfPlayer - 1);
        assertThat(line.getLine()).usingFieldByFieldElementComparator()
                .isEqualTo(bridges);
    }
}