package ladder;

import ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {
    @DisplayName("양쪽 방향을 가지는 경우 예외를 반환한다.")
    @Test
    void left_right() {
        assertThatThrownBy(() -> {
            new Direction(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("왼쪽방향을 가지고 있으면 true를 반환한다.")
    @Test
    void hasLeft() {
        Direction directionLeft = new Direction(true, false);

        assertThat(directionLeft.hasLeftDirection()).isTrue();
    }

    @DisplayName("오른쪽방향을 가지고 있으면 true를 반환한다.")
    @Test
    void hasRight() {
        Direction directionRight = new Direction(false, true);

        assertThat(directionRight.hasRightDirection()).isTrue();
    }
}
