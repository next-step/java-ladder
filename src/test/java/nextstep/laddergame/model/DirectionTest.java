package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.laddergame.exception.InvalidDirectionException;

public class DirectionTest {

    @DisplayName("방향이 인자로 주어졌을 때 정상적으로 Direction을 생성했는지 검증")
    @Test
    void constructTest() {
        Direction direction = new Direction(true, false);
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isTrue();
    }

    @DisplayName("왼쪽 오른쪽이 모두 true로 주어질 경우 예외를 던진다")
    @Test
    void invalidConstructTest() {
        assertThatThrownBy(() -> new Direction(true, true)).isInstanceOf(InvalidDirectionException.class);
    }

    @DisplayName("첫 방향의 left는 항상 false이고, right는 인자에 따라서 생성하는지 검증")
    @Test
    void firstTest() {
        Direction right = Direction.first(true);
        Direction notRight = Direction.first(false);

        assertThat(right.isRight()).isTrue();
        assertThat(notRight.isRight()).isFalse();

        assertThat(right.isLeft()).isFalse();
        assertThat(notRight.isLeft()).isFalse();
    }

    @DisplayName("마지막 방향의 right는 항상 false이고, left는 이전 방향에 따라 다른지 검증")
    @Test
    void lastTest() {
        Direction right = Direction.first(true);
        Direction notRight = Direction.first(false);

        assertThat(right.last().isRight()).isFalse();
        assertThat(notRight.last().isRight()).isFalse();

        assertThat(right.last().isLeft()).isTrue();
        assertThat(notRight.last().isLeft()).isFalse();
    }

    @DisplayName("오른쪽 방향의 다음 방향은 left가 true이고, right는 false임을 검증")
    @Test
    void rightNextTest() {
        Direction right = new Direction(false, true);

        assertThat(right.next(true).isLeft()).isTrue();
        assertThat(right.next(false).isLeft()).isTrue();

        assertThat(right.next(true).isRight()).isFalse();
        assertThat(right.next(false).isRight()).isFalse();
    }

    @DisplayName("왼쪽 방향의 다음 방향은 left가 false이고, right는 인자에 따라 다름을 검증")
    @Test
    void leftNextTest() {
        Direction left = new Direction(true, false);

        assertThat(left.next(true).isLeft()).isFalse();
        assertThat(left.next(false).isLeft()).isFalse();

        assertThat(left.next(true).isRight()).isTrue();
        assertThat(left.next(false).isRight()).isFalse();
    }
}
