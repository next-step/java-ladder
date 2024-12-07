package nextstep.laddergame.domain;

import nextstep.laddergame.service.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @DisplayName("사다리 존재 여부를 전달하여 Point 객체를 생성한다.")
    @Test
    void create() {
        Point actual = new Point(true, true);

        assertThat(actual).isEqualTo(new Point(true, true));
    }

    @DisplayName("첫번째에 위치한 Point 객체는 left 필드가 false이다.")
    @Test
    void first() {
        Point actual = Point.first(true);

        assertThat(actual).extracting("left").isEqualTo(false);
    }

    @DisplayName("마지막에 위치한 Point 객체는 current 필드가 false이다.")
    @Test
    void last() {
        Point actual = Point.last(true);

        assertThat(actual).isEqualTo(new Point(true, false));
    }

    @DisplayName("현재 Point 객체의 다음 Point 객체를 생성한다.")
    @Test
    void next() {
        Point left = new Point(false, true);

        Point actual = left.next(false);

        assertThat(actual).isEqualTo(new Point(true, false));
    }

    @DisplayName("Point 객체가 현재 위치에 존재하면 True를 반환한다.")
    @Test
    void isSet() {
        Point given = new Point(false, true);

        boolean actual = given.isSet();

        assertThat(actual).isTrue();
    }

    @CsvSource({"false,true,RIGHT", "true,false,LEFT", "false,false,SOUTH"})
    @ParameterizedTest(name = "왼쪽 Point={0}, 현재 Point={1}, 이동 방향={2}")
    void resolveMoveDirection(boolean left, boolean current, Direction expected) {
        Point given = new Point(left, current);

        Direction actual = given.resolveMoveDirection();

        assertThat(actual).isEqualTo(expected);
    }
}
