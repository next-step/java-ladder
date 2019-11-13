package game.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by yusik on 2019/11/14.
 */
class DirectionTest {

    @DisplayName("왼쪽 방향")
    @Test
    void getDirectionLeft() {
        // when
        Direction direction = Direction.getDirection(true, false);

        // then
        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @DisplayName("오른쪽 방향")
    @Test
    void getDirectionRight() {
        // when
        Direction direction = Direction.getDirection(false, true);

        // then
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("스테이")
    @Test
    void getDirectionStay() {
        // when
        Direction direction = Direction.getDirection(false, false);

        // then
        assertThat(direction).isEqualTo(Direction.STAY);
    }

    @DisplayName("미지원 방향")
    @Test
    void getDirectionException() {
        // then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.getDirection(true, true));
    }

    @DisplayName("왼쪽 방향 이동")
    @Test
    void moveLeft() {

        // given
        Direction direction = Direction.LEFT;
        int position = 5;

        // then
        assertThat(direction.move(position)).isEqualTo(position - 1);

    }

    @DisplayName("오른쪽 방향 이동")
    @Test
    void moveRight() {

        // given
        Direction direction = Direction.RIGHT;
        int position = 5;

        // then
        assertThat(direction.move(position)).isEqualTo(position + 1);

    }

    @DisplayName("정지")
    @Test
    void stay() {

        // given
        Direction direction = Direction.STAY;
        int position = 5;

        // then
        assertThat(direction.move(position)).isEqualTo(position);

    }
}