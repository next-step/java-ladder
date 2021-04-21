package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("Point 인스턴스에 첫번째 지점 생성 테스트")
    @Test
    void first() {
        // given
        boolean current = true;

        // when
        Point point = Point.first(current);

        // then
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("Point 인스턴스가 다음 지점 Point 인스턴스 생성 테스트")
    @Test
    void next() {
        // given
        boolean current = true;
        boolean next = false;

        // when
        Point point = Point.first(current).next(next);

        // then
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Point 인스턴스에 마지막 지점 생성 테스트")
    @Test
    void last() {
        // given
        boolean current = true;
        boolean next = false;

        // when
        Point point = Point.first(current).next(next).last();

        // then
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }

    @DisplayName("Point 인스턴스에 부적절한 값 입력시 예외처리 여부 테스트")
    @Test
    void invalid() {
        // given
        boolean current = true;
        boolean next = true;

        // when and then
        assertThatThrownBy(() -> Point.first(current).next(next))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상태 값이 유효하지 않습니다.");
    }

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.LEFT 인지 확인")
    @Test
    void left() {
        // given
        boolean current = true;
        boolean next = false;

        // when
        Point point = Point.first(current).next(next);

        // then
        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.RIGHT 인지 확인")
    @Test
    void right() {
        // given
        boolean current = false;
        boolean next = true;

        // when
        Point point = Point.first(current).next(next);

        // then
        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("Point 인스턴스의 다음 이동이 Direction.PASS 인지 확인")
    @Test
    void pass() {
        // given
        boolean current = false;
        boolean next = false;

        // when
        Point point = Point.first(current).next(next);

        // then
        assertThat(point.move()).isEqualTo(Direction.PASS);
    }
}