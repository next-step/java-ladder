package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {

    @Test
    @DisplayName("first point 생성")
    void create_first() {
        Point truePoint = Point.createFirst(() -> true);
        Point falsePoint = Point.createFirst(() -> false);
        assertAll(
            () -> assertThat(truePoint.isLeftLine()).isFalse(),
            () -> assertThat(truePoint.isRightLine()).isTrue(),
            () -> assertThat(falsePoint.isLeftLine()).isFalse(),
            () -> assertThat(falsePoint.isRightLine()).isFalse()
        );
    }

    @Test
    @DisplayName("next point 생성, 이전 Point 의 Direction.RIGHT 가 true 값을 가지면 다음에 생성할 Point 의 왼쪽은 무조건 같은 값을 가진다.")
    void create_next() {
        Point point = Point.createFirst(() -> true);
        assertThat(point.createNext(() -> true).isLeftLine()).isTrue();
    }

    @Test
    @DisplayName("이전 Point 의 Direction.RIGHT 가 false 이면 다음 생성할 Point 의 왼쪽은 랜덤 생성")
    void create_next_random() {
        Point point = Point.createFirst(() -> false);
        assertThat(point.createNext(() -> true).isLeftLine()).isFalse();
    }

    @Test
    @DisplayName("last point 생성, 마지막 Point 의 Direction.RIGHT 는 무조건 false")
    void create_last() {
        Point point = Point.createFirst(() -> true);
        assertThat(point.createLast().isRightLine()).isFalse();
    }

    @Test
    @DisplayName("오른쪽 이동 테스트")
    void move_right() {
        Point point = Point.createFirst(() -> true);
        assertThat(point.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽 이동 테스트")
    void move_left() {
        Point point = Point.createFirst(() -> true).createLast();
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("라인이 유지되는 경우")
    void move_down() {
        Point point = Point.createFirst(() -> false);
        assertThat(point.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("equals and hashCode 테스트")
    void equals_and_hashcode() {
        Point point = Point.createFirst(() -> true);
        assertThat(point).isEqualTo(Point.createFirst(() -> true)).hasSameHashCodeAs(Point.createFirst(() -> true));
    }
}
