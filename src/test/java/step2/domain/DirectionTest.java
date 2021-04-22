package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("첫번째 Direction은 왼쪽은 false여야 한다.")
    void first() {
        Direction direction = Direction.first(true);
        assertThat(direction.isRight()).isTrue();
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    @DisplayName("중간 Direction이 왼쪽이 true일경우 오른쪽은 false로 고정생성")
    void middleDirectionTest1() {
        Direction firstDirection = Direction.first(true);
        Direction middleDirection = firstDirection.middle(false);
        assertThat(middleDirection.isLeft()).isTrue();
        assertThat(middleDirection.isRight()).isFalse();
    }

    @Test
    @DisplayName("마지막 Direction의 오른쪽은 무조건 false로 생성")
    void lastDirectionTest() {
        Direction firstDirection = Direction.first(true);
        Direction lastDirection = firstDirection.last();
        assertThat(lastDirection.isLeft()).isTrue();
        assertThat(lastDirection.isRight()).isFalse();
    }

    @Test
    @DisplayName("left가 ture이면 true")
    void isLeftTest() {
        Direction firstDirection = Direction.first(true);
        Direction middleDirection = firstDirection.middle(false);
        assertThat(middleDirection.isLeft()).isTrue();
    }

    @Test
    @DisplayName("right가 true이면 true")
    void isRightTest() {
        Direction firstDirection = Direction.first(true);
        assertThat(firstDirection.isRight()).isTrue();
    }
}