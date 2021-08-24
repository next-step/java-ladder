package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PointTest {

    @Test
    @DisplayName("Point 생성 - position 값이 0보다 작은 경우")
    public void lessThanZeroPosition() {
        // given
        int position = -1;
        Direction direction = Direction.NONE;
        String message = String.format("위치 값은 0보다 작을 수 없습니다 -> %d", position);

        // when
        ThrowingCallable throwingCallable = () -> new Point(position, direction);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("Point 생성 - direction 값이 null 인 경우")
    public void nullDirection() {
        // given
        int position = 0;
        Direction direction = null;
        String message = "입력값은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Point(position, direction);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("Point 생성 - position 0에서 direction 값이 LEFT 인 경우")
    public void positionZeroDirectionLeft() {
        // given
        int position = 0;
        Direction direction = Direction.LEFT;
        String message = "0의 위치에서는 LEFT (direction) 값을 가질 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Point(position, direction);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @Test
    @DisplayName("isRightDirection 테스트")
    public void isRightDirection() {
        // given
        Point point = new Point(0, Direction.RIGHT);
        boolean expected = true;

        // when
        boolean rightDirection = point.isRightDirection();

        // then
        assertThat(rightDirection).isEqualTo(expected);
    }

}