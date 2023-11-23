package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    @DisplayName("왼쪽, 오른쪽 각각의 사다리 존재 유무를 입력으로, Point 클래스를 생성한다.")
    void testPointConstructor() {
        //given, when
        Point point = Point.first(false);

        //then
        assertThat(point).isNotNull();
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 각각의 사다리 존재 유무가 true, true이면, Point 객체는 생성시에 IllegalArgumentException이 발생한다.")
    void testPointConstructorWithTrueTrue() {
        //given, when, then
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양쪽에 사다리가 존재할 수 없습니다.");
    }

    @Test
    @DisplayName("왼쪽에만 사다리가 존재하는 경우 move메서드를 사용하면, 왼쪽 방향을 반환한다.")
    void testMoveWhenOnlyLeftRungIsTrue() {
        //given
        Point point = Point.first(true).next(false);

        //when
        MoveDirection direction = point.move();

        //then
        assertThat(direction).isEqualTo(MoveDirection.LEFT);
    }

    @Test
    @DisplayName("오른쪽에만 사다리가 존재하는 경우 move메서드를 사용하면, 오른쪽 방향을 반환한다.")
    void testMoveWhenOnlyRightRungIsTrue() {
        //given
        Point point = Point.first(true);

        //when
        MoveDirection direction = point.move();

        //then
        assertThat(direction).isEqualTo(MoveDirection.RIGHT);
    }

    @Test
    @DisplayName("양쪽 다 사다리가 존재하지 않는 경우 move메서드를 사용하면, 이동하지 않는다.")
    void testMoveWhenNoRungIsTrue() {
        //given
        Point point = Point.first(false).next(false);

        //when
        MoveDirection direction = point.move();

        //then
        assertThat(direction).isEqualTo(MoveDirection.NONE);
    }

    @Test
    @DisplayName("next() 메서드를 사용하면, 현재 Point 오른쪽에 위치하는 Point 객체를 생성할 수 있다.")
    void testNext() {
        //given, when
        Point point = Point.first(false).next(true);

        //then
        assertThat(point).isNotNull();
    }

    @Test
    @DisplayName("first() 메서드를 사용하면, 맨 왼쪽에 위치하는 Point 객체를 생성할 수 있다.")
    void testFirst() {
        //given, when
        Point point = Point.first(false);

        //then
        assertThat(point).isNotNull();
    }

    @Test
    @DisplayName("last() 메서드를 사용하면, 맨 오른쪽에 위치하는 Point 객체를 생성할 수 있다.")
    void testLast() {
        //given, when
        Point point = Point.first(false).last(false);

        //then
        assertThat(point).isNotNull();
    }
}
