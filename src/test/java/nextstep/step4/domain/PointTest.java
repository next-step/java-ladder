package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Point 테스트")
class PointTest {

    @DisplayName("첫번째 포인트 위치 확인")
    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"true:1", "false:0"})
    void firstPoint(boolean moveable, int index) {
        assertThat(Point.first(moveable).move()).isEqualTo(index);
    }

    @DisplayName("마지막 포인트 위치 확인")
    @Test
    void last() {
        Point point = Point.first(false).next(true).next(true).last();
        assertThat(point.move()).isEqualTo(3);
    }

    @DisplayName("포인트 이동 없음")
    @Test
    void next_stay() {
        Point point = Point.first(false).next(false);
        assertThat(point.move()).isEqualTo(1);
    }

    @DisplayName("포인트 오른쪽 이동")
    @Test
    void next_right() {
        Point point = Point.first(true).next(false);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("포인트 왼쪽 이동")
    @Test
    void next_left() {
        Point point = Point.first(false).next(true);
        assertThat(point.move()).isEqualTo(2);
    }
}
