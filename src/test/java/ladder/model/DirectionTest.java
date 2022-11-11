package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("처음 생성되는 방향은 왼쪽 이동이 불가능하다.")
    @Test
    void first() {
        Direction direction = Direction.first(true);
        assertThat(direction.isLeft()).isFalse();
    }

    @DisplayName("마지막 생성되는 방향은 오른쪽 이동이 불가능하다.")
    @Test
    void last() {
        Direction direction = Direction.first(true).last();
        assertThat(direction.isRight()).isFalse();
    }

    @DisplayName("이전 방향을 기준으로 다음 방향이 생성된다.")
    @Test
    void next() {
        Direction direction = Direction.first(false).next(false);
        assertThat(direction).isEqualTo(new Direction(false, false));
    }

    @DisplayName("양방향일 경우 예외가 발생한다.")
    @Test
    void validate() {
        assertThatThrownBy(() -> {
            new Direction(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
