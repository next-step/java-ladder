package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("첫번째 Direction은 왼쪽은 false여야 한다.")
    void first() {
        Direction direction = Direction.first(new FixedGenerator(true));
        assertThat(direction.isRight()).isTrue();
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    @DisplayName("중간 Direction이 왼쪽이 true일경우 오른쪽은 false로 고정생성")
    void middleDirectionTest1() {
        Direction middleDirection = Direction.middle(true, new FixedGenerator(false));
        assertThat(middleDirection.isLeft()).isTrue();
        assertThat(middleDirection.isRight()).isFalse();
    }

    @Test
    @DisplayName("마지막 Direction은 오른쪽은 무조건 false로 생성")
    void lastDirectionTest() {
        Direction lastDirection = Direction.last(true);
        assertThat(lastDirection.isLeft()).isTrue();
        assertThat(lastDirection.isRight()).isFalse();
    }

    @Test
    @DisplayName("left가 true이면 true")
    void isLeftTest() {
        assertThat(Direction.middle(true, new FixedGenerator(false)).isLeft()).isTrue();
    }

    @Test
    @DisplayName("right가 true이면 true")
    void isRightTest() {
        assertThat(Direction.middle(false, new FixedGenerator(true)).isRight()).isTrue();
    }
}