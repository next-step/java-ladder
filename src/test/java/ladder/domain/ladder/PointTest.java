package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("첫번째 포인트가 False 일 경우")
    void point_first_false_move_Test() {
        Point first = Point.createFirstPoint(false);
        assertThat(first.isMovableRight()).isFalse();
    }

    @Test
    @DisplayName("첫번째 포인트가 true 일 경우")
    void point_first_true_move_Test() {
        Point first = Point.createFirstPoint(true);
        assertThat(first.isMovableRight()).isTrue();
    }

    @Test
    @DisplayName("포인트 false 생성 이후 다음 포인트가 false 일 경우")
    void point_next_false_move_Test() {
        Point first = Point.createFirstPoint(false);
        Point next = first.next(false);
        assertThat(next.isMovableRight()).isFalse();
    }

    @Test
    @DisplayName("포인트 false 생성 이후 다음 포인트가 true 일 경우")
    void point_next_true_move_Test() {
        Point first = Point.createFirstPoint(false);
        Point next = first.next(true);
        assertThat(next.isMovableRight()).isTrue();
    }

    @Test
    @DisplayName("포인트 다음 포인트가 false 일 경우 마지막 포인트가 이동 불가능 할 경우")
    void point_last_move_false_Test() {
        Point first = Point.createFirstPoint(false);
        Point next = first.next(false);
        Point last = next.last();
        assertThat(last.isMovableRight()).isFalse();
    }
}
