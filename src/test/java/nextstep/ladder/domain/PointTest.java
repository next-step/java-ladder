package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("false, true 인 경우 오른쪽")
    void right() {
        Point point = new Point(false, true);
        assertThat(point.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("true, false 인 경우 왼쪽")
    void left() {
        Point point = new Point(true, false);
        assertThat(point.getDirection()).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("false, false 인 경우 내려가기")
    void pass() {
        Point point = new Point(false, false);
        assertThat(point.getDirection()).isEqualTo(Direction.PASS);
    }

    @Test
    @DisplayName("first")
    void first() {
        assertThat(Point.first(true).getLeft()).isEqualTo(false);
        assertThat(Point.first(true).getRight()).isEqualTo(true);
    }

    @Test
    @DisplayName("middle")
    void middle() {
        assertThat(Point.middle(true, false).getLeft()).isEqualTo(true);
        assertThat(Point.middle(true, false).getRight()).isEqualTo(false);

        assertThat(Point.middle(false, true).getLeft()).isEqualTo(false);
        assertThat(Point.middle(false, true).getRight()).isEqualTo(true);
    }

    @Test
    @DisplayName("last")
    void last() {
        assertThat(Point.last(true).getLeft()).isEqualTo(true);
        assertThat(Point.last(true).getRight()).isEqualTo(false);

        assertThat(Point.last(false).getLeft()).isEqualTo(false);
        assertThat(Point.last(false).getRight()).isEqualTo(false);
    }
}
