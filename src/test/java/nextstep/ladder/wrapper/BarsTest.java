package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Bar;
import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BarsTest {

    /**
     * user1  user2  user3
     *      |-----|     |
     *
     * 상황에서 이동 테스트
     */
    private static Stream<Arguments> ladderMovedTestCase() {
        return Stream.of(
                Arguments.of(Position.valueOf(0), Position.valueOf(1)), // 0 -> 1
                Arguments.of(Position.valueOf(1), Position.valueOf(0)) // 1 -> 0
        );
    }

    @DisplayName("Bars 생성 테스트")
    @Test
    void create_Bars_생성테스트() {
        // given
        Bars bars = Bars.valueOf(Bar.init(), Bar.valueOf(true));
        // when
        Bars expected = Bars.valueOf(Bar.init(), Bar.valueOf(true));
        // then
        assertThat(bars).isEqualTo(expected);
    }

    @DisplayName("move 이동 테스트(사다리 모양: |-----|)")
    @ParameterizedTest(name = "move 테스트 Participant 위치: {0} :: EndPosition: {1}")
    @MethodSource(value = "ladderMovedTestCase")
    void move_테스트(Position userPosition, Position endPosition) {
        // given
        Bars line = Bars.valueOf(Bar.init(), Bar.valueOf(true), Bar.init());
        // when
        Position movedPosition = line.move(userPosition);
        // then
        assertThat(movedPosition).isEqualTo(endPosition);
    }
}
