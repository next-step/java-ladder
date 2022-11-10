package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @DisplayName("왼쪽으로 이동한다.")
    @Test
    void left() {
        Direction direction = new Direction(true, false);

        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isDown()).isFalse();
    }

    @DisplayName("오른쪽으로 이동한다.")
    @Test
    void right() {
        Direction direction = new Direction(false, true);

        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isTrue();
        assertThat(direction.isDown()).isFalse();
    }

    @DisplayName("아래쪽으로 이동한다.")
    @Test
    void down() {
        Direction direction = new Direction(false, false);

        assertThat(direction.isLeft()).isFalse();
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isDown()).isTrue();
    }

}