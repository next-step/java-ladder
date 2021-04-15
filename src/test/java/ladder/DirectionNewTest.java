package ladder;

import ladder.domain.DirectionNew;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionNewTest {
    @DisplayName("양쪽 방향을 가지는 경우 예외를 반환한다.")
    @Test
    void left_right() {
        assertThatThrownBy(() -> {
            new DirectionNew(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("왼쪽방향을 가지고 있으면 true를 반환한다.")
    @Test
    void hasLeft() {
        DirectionNew directionLeft = new DirectionNew(true, false);

        assertThat(directionLeft.hasLeftDirection()).isTrue();
    }

    @DisplayName("오른쪽방향을 가지고 있으면 true를 반환한다.")
    @Test
    void hasRight() {
        DirectionNew directionRight = new DirectionNew(false, true);

        assertThat(directionRight.hasRightDirection()).isTrue();
    }

    @DisplayName("왼쪽 또는 오른쪽 방향을 가지고 있으면 true를 반환한다.")
    @Test
    void hasDirection() {
        DirectionNew direction1 = new DirectionNew(false, true);
        DirectionNew direction2 = new DirectionNew(true, false);

        assertThat(direction1.hasDirection()).isTrue();
        assertThat(direction2.hasDirection()).isTrue();
    }

}
