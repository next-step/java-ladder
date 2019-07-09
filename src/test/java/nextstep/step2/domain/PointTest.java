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
            () -> assertThat(truePoint.getIndex()).isEqualTo(0),
            () -> assertThat(truePoint).isNotEqualTo(falsePoint)
        );
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
