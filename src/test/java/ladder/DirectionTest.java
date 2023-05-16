package ladder;

import ladder.model.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DirectionTest {
    @DisplayName("각 라인의 첫번째 위치를 생성할 수 있다")
    @Test
    void createFirst() {
        Direction direction = Direction.createFirst(true);
        assertThat(direction).isEqualTo(new Direction(false, true));
    }

    @DisplayName("현재 위치에서 다음 Direction을 생성할 수 있다")
    @Test
    void createNext() {
        Direction direction = new Direction(false, false);
        Direction nextDirection = direction.createNext(true);
        assertThat(nextDirection).isEqualTo(new Direction(false, true));
    }

    @DisplayName("각 라인의 마지막 위치를 생성할 수 있다")
    @Test
    void createLast() {
        Direction direction = new Direction(false, true);
        Direction lastDirection = direction.createLast();
        assertThat(lastDirection).isEqualTo(new Direction(true, false));
    }

    @DisplayName("좌, 우 라인이 겹치는 위치는 생성할 수 없다")
    @Test
    void createFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Direction(true, true));
    }

    @DisplayName("각 위치에 우측 라인이 있는지 확인할 수 있다")
    @Test
    void right() {
        Direction direction = new Direction(false, true);
        assertThat(direction.hasRight()).isTrue();
    }

    @DisplayName("각 위치에 좌측 라인이 있는지 확인할 수 있다")
    @Test
    void left() {
        Direction direction = new Direction(true, false);
        assertThat(direction.hasLeft()).isTrue();
    }
}
