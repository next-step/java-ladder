package nextstep.ladder.domain.element;

import nextstep.ladder.domain.strategy.LineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.fixture.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PillarTest {

    @DisplayName("Line 생성하는 Strategy로 처음 Pillar를 생성하면 Right Line을가지는 Pillar가 생성된다.")
    @Test
    void should_make_start_pillar_right_line() {
        //arrange, act
        Pillar pillar = Pillar.makeStart(CREATE_STRATEGY);

        //assert
        assertThat(pillar).isEqualTo(RIGHT_LINE_PILLAR);
    }

    @DisplayName("Line 생성하는 Strategy로 처음 Pillar를 생성하면 Right가 아닌 Line을가지는 Pillar가 생성된다.")
    @Test
    void should_make_start_pillar_none_line() {
        //arrange, act
        Pillar pillar = Pillar.makeStart(NOT_CREATE_STRATEGY);

        //assert
        assertThat(pillar).isEqualTo(NONE_LINE_PILLAR);
    }

    @DisplayName("마지막 Pillar는 이전 Pillar의 Line 영향을 받아 생성한다.")
    @MethodSource
    @ParameterizedTest
    void should_make_end_pillar_with_prev_line(Pillar prevPillar, Pillar expectedPillar) {
        //arrange, act
        Pillar pillar = prevPillar.makeEnd();

        //assert
        assertThat(pillar).isEqualTo(expectedPillar);
    }

    private static Stream<Arguments> should_make_end_pillar_with_prev_line() {
        return Stream.of(
                Arguments.of(NONE_LINE_PILLAR, NONE_LINE_PILLAR),
                Arguments.of(RIGHT_LINE_PILLAR, LEFT_LINE_PILLAR),
                Arguments.of(LEFT_LINE_PILLAR, NONE_LINE_PILLAR)
        );
    }

    @DisplayName("첫번째와 마지막을 제외한 Pillar들은 전 Line의 종류와 LineCreateStrategy의 영향을 받는다")
    @MethodSource
    @ParameterizedTest
    void should_make_end_pillar_with_prev_line_and_strategy(Pillar prvPillar, LineCreateStrategy lineCreateStrategy, Pillar expectedPillar) {
        //arrange, act
        Pillar pillar = prvPillar.makeMiddle(lineCreateStrategy);

        //assert
        assertThat(pillar).isEqualTo(expectedPillar);
    }

    private static Stream<Arguments> should_make_end_pillar_with_prev_line_and_strategy() {
        return Stream.of(
                Arguments.of(NONE_LINE_PILLAR, CREATE_STRATEGY, RIGHT_LINE_PILLAR),
                Arguments.of(NONE_LINE_PILLAR, NOT_CREATE_STRATEGY, NONE_LINE_PILLAR),
                Arguments.of(RIGHT_LINE_PILLAR, CREATE_STRATEGY, LEFT_LINE_PILLAR),
                Arguments.of(RIGHT_LINE_PILLAR, NOT_CREATE_STRATEGY, LEFT_LINE_PILLAR),
                Arguments.of(LEFT_LINE_PILLAR, CREATE_STRATEGY, RIGHT_LINE_PILLAR),
                Arguments.of(LEFT_LINE_PILLAR, NOT_CREATE_STRATEGY, NONE_LINE_PILLAR)
        );
    }

    @DisplayName("Pillar는 Right Line이 있을경우 true를 리턴한다")
    @Test
    void should_return_line_right() {
        //arrange
        Pillar pillar = Pillar.makeStart(() -> true);

        //act
        boolean isRight = pillar.hasRightLine();

        //assert
        assertTrue(isRight);
    }

    @DisplayName("Pillar는 Right Line이 없을경우 true를 리턴한다")
    @Test
    void should_return_line_not_right() {
        //arrange
        Pillar pillar = Pillar.makeStart(() -> false);

        //act
        boolean isRight = pillar.hasRightLine();

        //assert
        assertFalse(isRight);
    }

}