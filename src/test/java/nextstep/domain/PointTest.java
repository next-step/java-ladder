package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void 오른쪽으로_움직인다() {
        // given & when
        Point result = Point.first(true);

        // then
        assertThat(result.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void 아래로_움직인다() {
        // given & when
        Point result = Point.first(false);

        // then
        assertThat(result.move()).isEqualTo(Direction.DOWN);
    }

    @Test
    void 왼쪽으로_움직인다() {
        // given & when
        Point result = Point.first(true).next(false);

        // then
        assertThat(result.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void 연속적으로_점을_생성하면_예외가_발생한다() {
        // given & when & then
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 라인은 연속적으로 존재할 수 없습니다.");
    }
}
