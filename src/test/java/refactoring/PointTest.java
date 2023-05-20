package refactoring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;
import static refactoring.domain.LineStatus.CONNECTION;
import static refactoring.domain.LineStatus.DETACHMENT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoring.domain.Direction;
import refactoring.domain.Name;
import refactoring.domain.Point;

class PointTest {

    @DisplayName("첫 번째 참가자의 순서는 0이고 처음의 방향을 갖는다.")
    @Test
    void test1() throws Exception {
        //given, when
        Point result = Point.first(DETACHMENT);

        assertThat(result).isEqualTo(new Point(0, Direction.first(DETACHMENT)));
    }

    @DisplayName("마지막 전까지의 참가자는 첫 번째 참가자에 이어서 생성한다.")
    @Test
    void test2() throws Exception {
        //given when
        Point next = Point.first(CONNECTION).next();

        then(next).isEqualTo(new Point(1, new Direction(CONNECTION, DETACHMENT)));
    }

    @DisplayName("이전 참가자의 방향이 connection이면 다음 참가자는 Detachment이다.")
    @Test
    void test3() throws Exception {
        Point next = Point.first(CONNECTION).next();

        then(next).isEqualTo(new Point(1, new Direction(CONNECTION, DETACHMENT)));
    }

    @DisplayName("참가자가 3명 일때 순서 2와 마지막 방향을 갖는다.")
    @Test
    void test4() throws Exception {
        //given
        Point second = Point.first(CONNECTION).next();

        //when
        Point last = second.last();

        //then
        then(last).isEqualTo(new Point(2, new Direction(DETACHMENT, DETACHMENT)));
    }

    @DisplayName("detachment - connection일 경우 오른쪽으로 이동한다.")
    @Test
    void test5() throws Exception {
        //given
        Point a = Point.first(CONNECTION);
        //when
        int result = a.move();
        //then
        assertThat(result).isEqualTo(1);
    }


    @DisplayName("connection - detachment일 경우 왼쪽으로 이동한다.")
    @Test
    void test6() throws Exception {
        //given
        Point b = Point.first(CONNECTION).next();
        //when
        int result = b.move();
        //then
        assertThat(result).isZero();
    }

    @DisplayName("detachment - detachment일 경우 왼쪽으로 이동한다.")
    @Test
    void test7() throws Exception {
        //given
        Point a = Point.first(DETACHMENT);
        //when
        int result = a.move();
        //then
        assertThat(result).isZero();
    }

    @DisplayName("이름은 5글자를 넘어갈 경우 예외를 던진다.")
    @Test
    void test8() throws Exception {
        assertThatThrownBy(() -> {
            new Name("asdfdg");
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름의 길이는 5자 이하여야 합니다.");
    }
}
