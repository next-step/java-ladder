package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    public static Stream<Arguments> preparingSeveralStrategy() {
        return Stream.of(
                Arguments.of((BridgeStrategy) () -> false, 5, 0),
                Arguments.of((BridgeStrategy) () -> true, 5, 2), // 연속으로 다리를 놓을 수 없기 때문에
                Arguments.of((BridgeStrategy) () -> true, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "preparingSeveralStrategy")
    void 다리_세우기_전략에_대한_결과_테스트(BridgeStrategy strategy, int countOfPerson, int result) {
        Line line = Line.createLine(countOfPerson, strategy);
        assertThat(line.getBridges()).hasSize(countOfPerson - 1);

        long count = line.getBridges().stream()
                .filter(b -> b) // 세워져 있는 다리
                .count();
        assertThat(count).isEqualTo(result);
    }

    @Test
    void 왼쪽으로_또는_오른쪽으로_이동한다() {
        /**
         * users :    [a][b][c][d][e]
         * liens :     |--|  |--|  |
         * results:   [b][a][d][c][e]
         */
        Line line = Line.createLine(5, () -> true);
        assertThat(line.getNextPosition(0)).isEqualTo(1);
        assertThat(line.getNextPosition(1)).isEqualTo(0);
        assertThat(line.getNextPosition(2)).isEqualTo(3);
        assertThat(line.getNextPosition(3)).isEqualTo(2);
        assertThat(line.getNextPosition(4)).isEqualTo(4);
    }
}