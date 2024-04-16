package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("left와 current가 true면 예외 발생")
    void invalid() {
        assertThatThrownBy(() -> Point.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("first()로 생성 시 isFirst true")
    void first() {
        Point first = Point.first(true);
        assertThat(first.isFirst()).isTrue();
        assertThat(first.isLast()).isFalse();
    }

    @Test
    @DisplayName("last()로 생성 시 isLast true")
    void last() {
        Point last = Point.last(true);
        assertThat(last.isLast()).isTrue();
        assertThat(last.isFirst()).isFalse();
    }

    @Test
    @DisplayName("of()로 생성 시 isLast와 isFirst는 false")
    void of() {
        Point of = Point.of(true, false);
        assertThat(of.isLast()).isFalse();
        assertThat(of.isFirst()).isFalse();
    }

    @Nested
    @DisplayName("move()")
    class move {
        @Test
        @DisplayName("left만 true면 왼쪽으로 이동")
        void left() {
            Point point = new Point(true, false);
            assertThat(point.move()).isEqualTo(PointDirection.LEFT);
        }

        @Test
        @DisplayName("current만 true면 오른쪽으로 이동")
        void right() {
            Point point = new Point(false, true);
            assertThat(point.move()).isEqualTo(PointDirection.RIGHT);
        }

        @Test
        @DisplayName("left와 current가 false면 아래로 이동")
        void down() {
            Point point = new Point(false, false);
            assertThat(point.move()).isEqualTo(PointDirection.DOWN);
        }

        @Test
        @DisplayName("left와 current가 false면 아래로 이동")
        void next() {
            Point point = new Point(false, false);
            assertThat(point.move()).isEqualTo(PointDirection.DOWN);
        }
    }
}
