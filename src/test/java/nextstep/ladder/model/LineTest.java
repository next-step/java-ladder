package nextstep.ladder.model;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.model.factory.LineFactory;

class LineTest {

    @ParameterizedTest(name = "각 세로선에 대해서 move 명령을 수행 했을 때, 정상적으로 이동하는지 확인합니다; 인원 수: {0}")
    @MethodSource("provideLineMovingSource")
    void move(int countOfPerson, List<Integer> expectedPositions) {
        Line line = LineFactory.create(countOfPerson, () -> true);

        List<Integer> positions = IntStream.range(0, countOfPerson)
            .map(line::move)
            .boxed()
            .collect(toList());

        assertThat(positions).isEqualTo(expectedPositions);
    }

    private static Stream<Arguments> provideLineMovingSource() {
        return Stream.of(
            Arguments.of(3, List.of(1, 0, 2)),
            Arguments.of(4, List.of(1, 0, 3, 2)),
            Arguments.of(5, List.of(1, 0, 3, 2, 4))
        );
    }
}
