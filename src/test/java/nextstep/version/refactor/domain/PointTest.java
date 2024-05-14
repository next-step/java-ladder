package nextstep.version.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {


    @DisplayName("PASS")
    @Test
    void pass() {
        // beforeLine(x), current(x)
        Point point = Point.first(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("NEXT_LINE")
    @Test
    void nextLine() {
        // beforeLine(x), current(x)
        Point point = Point.first(true);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("이전라인이 연결되어 있으면 이전라인으로 이동한다.")
    @Test
    void beforeLine() {
        // beforeLine(x), current(x)
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(-1);
    }

    @DisplayName("포인트는 이어지는 라인이 둘다 이어졌을 경우 예외를 던진다.")
    @Test
    void create() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫 번째 라인은 항상 이전 라인이 없다.")
    @Test
    void first() {
        assertThatCode(() -> Point.first(true))
                .doesNotThrowAnyException();
    }

    @DisplayName("현재 포인트 기준으로 다음 포인트를 생성할 수 있다.")
    @Test
    void next() {
        Point point = Point.first(true).next(false);
        assertThat(point.getBeforeLine()).isTrue();
        assertThat(point.getCurrent()).isFalse();
    }

    @DisplayName("마지막포인트는 현재 라인을 가질 수 없다.")
    @Test
    void last() {
        Point point = Point.first(true).last();
        assertThat(point.getBeforeLine()).isTrue();
        assertThat(point.getCurrent()).isFalse();
    }
}

