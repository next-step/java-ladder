package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LadderTest {

    @DisplayName("시작 포인트에서 도착 지점까지 움직이는 테스트")
    @ParameterizedTest
    @MethodSource("ladderTestSource")
    void arrive_index_test(int height, String userName, String result) {
        LadderInput ladderInput = generateLadderInOut();
        LadderLine ladderLine = new LadderLine(ladderInput.getCountOfUser(), height, () -> true);
        Ladder ladder = new Ladder(ladderInput, ladderLine);
        assertThat(ladder.getResult(userName)).isEqualTo(result);
    }

    LadderInput generateLadderInOut() {
        return new LadderInput(Lists.list("1", "2", "3"), new Users(Lists.list("a", "b", "c")));
    }

    static Stream<Arguments> ladderTestSource() {
        return Stream.of(
                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(3, "a", "2"),

                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(5, "a", "2"),

                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(5, "b", "1"),
                /**
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 * |-----|     |
                 */
                arguments(5, "c", "3")
        );
    }
}
