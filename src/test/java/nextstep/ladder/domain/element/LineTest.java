package nextstep.ladder.domain.element;

import nextstep.ladder.domain.strategy.LineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @DisplayName("사다리의 가로Line을 생성시 Strategy가 필요히다")
    @Test
    public void make_Line() throws Exception {
        //arrange, act
        Line line = Line.make(() -> true);

        //assert
        assertThat(line).isInstanceOf(Line.class);
    }

    @DisplayName("사다리의 가로Line을 생성시 Strategy가 없으면 IllegalArgumentException을 반환한다")
    @Test
    public void throw_exception_when_strategy_is_null() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Line.make(null));
    }

    @DisplayName("사다리의 가로Line 기본생성은 움직일수 있는 전략이면 Right를 반환한다")
    @Test
    public void make_LEFT_Line_using_movable_strategy() throws Exception {
        //arrange
        LineCreateStrategy lineCreateStrategy = () -> true;

        //act
        Line line = Line.make(lineCreateStrategy);

        //assert
        assertThat(line).isEqualTo(Line.RIGHT);
    }

    @DisplayName("사다리의 가로Line 기본생성은 움직일수 없는 전략이면 None를 반환한다")
    @Test
    public void make_NONE_Line_using_not_movable_strategy() throws Exception {
        //arrange
        LineCreateStrategy lineCreateStrategy = () -> false;

        //act
        Line line = Line.make(lineCreateStrategy);

        //assert
        assertThat(line).isEqualTo(Line.NONE);
    }

    @DisplayName("사다리의 가로Line 다음번생성(이전Line이있을경우)은 이전 Line이 Right일경우 LEFT를 반환해야한다")
    @Test
    public void make_next_Line_LEFT_when_prev_Line_is_RIGHT() throws Exception {
        //arrange
        Line prevLine = Line.make(() -> true);

        //act
        Line line = prevLine.makeNext(() -> true);

        //assert
        assertThat(line).isEqualTo(Line.LEFT);
    }

    @DisplayName("사다리의 가로Line 다음번생성(이전Line이있을경우)은 이전 Line이 Right가 아닐경우 움직일수 있는 전략이면 Right를 반환")
    @Test
    public void make_next_Line_RIGHT_using_movable_strategy() throws Exception {
        //arrange
        Line prevLine = Line.make(() -> false);

        //act
        Line line = prevLine.makeNext(() -> true);

        //assert
        assertThat(line).isEqualTo(Line.RIGHT);
    }

    @DisplayName("사다리의 가로Line 다음번생성(이전Line이있을경우)은 이전 Line이 LEFT가 아닐경우 움직일수 없는 전략이면 NONE를 반환")
    @Test
    public void make_next_Line_NONE_using_not_movable_strategy() throws Exception {
        //arrange
        Line prevLine = Line.make(() -> false);

        //act
        Line line = prevLine.makeNext(() -> false);

        //assert
        assertThat(line).isEqualTo(Line.NONE);
    }

    @DisplayName("사다리의 가로Line 마지막막생성(이전Line이있을경우)은 이전 Line이 Right 일경우 LEFT반환")
    @Test
    public void make_end_Line_LEFT_when_prev_line_is_RIGHT() throws Exception {
        //arrange
        Line prevLine = Line.make(() -> true);

        //act
        Line line = prevLine.makeEnd();

        //assert
        assertThat(line).isEqualTo(Line.LEFT);
    }

    @DisplayName("사다리의 가로Line 마지막막생성(이전Line이있을경우)은 이전 Line이 Right가 아닐경우 NONE반환")
    @Test
    public void make_end_Line_NONE_when_prev_line_is_not_RIGHT() throws Exception {
        //arrange
        Line prevLine = Line.make(() -> false);

        //act
        Line line = prevLine.makeEnd();

        //assert
        assertThat(line).isEqualTo(Line.NONE);
    }

}