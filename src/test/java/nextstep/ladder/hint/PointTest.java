package nextstep.ladder.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("Point move 테스트")
    @ParameterizedTest(name = "Point 초기값 설정 {0} 및 move 시 결과 값 {1} 테스트")
    @CsvSource(value = {"TRUE, 1", "FALSE, 0"})
    void first(Boolean actual, int expected) {
        // when
        int point = Point.first(actual).move();
        // then
        assertThat(point).isEqualTo(expected);
    }

    @DisplayName("Point move 좌우 이동 불가 테스트")
    @Test
    void next_stay() {
        Point second = Point.first(FALSE).next(FALSE);
        // then
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("Point move 왼쪽 이동 테스트")
    @Test
    void next_left() {
        // given
        Point second = Point.first(TRUE).next(FALSE);
        // when
        int move = second.move();
        // then
        assertThat(move).isZero();
    }

    @DisplayName("Point move 오른쪽 이동 테스트")
    @Test
    void next_right() {
        // given
        Point second = Point.first(FALSE).next(TRUE);
        // when
        int move = second.move();
        // then
        assertThat(move).isEqualTo(2);
    }

    @DisplayName("Point move left 테스트")
    @Test
    void next() {
        // given
        Point second = Point.first(TRUE).next();
        // when
        int move = second.move();
        // then
        assertThat(move).isZero();
    }
}
