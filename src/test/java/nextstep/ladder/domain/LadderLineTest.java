package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderLineTest {

    @DisplayName("시작 포인트에서 도착 지점까지 움직이는 테스트")
    @ParameterizedTest
    @MethodSource("ladderLineTestSource")
    void arrive_index_test(LadderLine ladderLine, int startIdx, int expectArriveIndex) {
        assertThat(ladderLine.getArriveIdx(startIdx)).isEqualTo(expectArriveIndex);
    }

    static Stream<Arguments> ladderLineTestSource() {
        return Stream.of(
                /**
                 * |
                 * |
                 * |
                 */
                arguments(new LadderLine(1, 2, () -> true), 0, 0),

                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(new LadderLine(3, 5, () -> true), 0, 1),

                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(new LadderLine(3, 5, () -> true), 2, 2),
                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(new LadderLine(3, 5, () -> true), 1, 0)
        );
    }
}
