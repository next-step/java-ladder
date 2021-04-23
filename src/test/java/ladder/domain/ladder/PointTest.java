package ladder.domain.ladder;

import ladder.exception.IllegalBooleanArgumentsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {


    @DisplayName("Point 인스턴스가 첫번째 Point를 반환하는 기능 테스트")
    @Test
    void 기능_첫번째_포인트_반환() {

        // when and then
        assertAll(
                () -> assertThat(Point.first(TRUE).move()).isEqualTo(1),
                () -> assertThat(Point.first(FALSE).move()).isEqualTo(0)
        );
    }

    @DisplayName("Point 인스턴스가 마지막 Point를 반환하는 기능 테스트")
    @Test
    void 기능_마지막_포인트_반환() {
        // when and then
        assertThat(Point.first(TRUE).last().move()).isEqualTo(0);
        assertThat(Point.first(FALSE).last().move()).isEqualTo(1);
    }


    @DisplayName("Point 인스턴스가 다음 Point를 반환하는 기능 테스트")
    @Test
    void 기능_다음_포인트_반환() {

        assertAll(
                () -> assertThat(Point.first(TRUE).next(FALSE).move()).isEqualTo(0),
                () -> assertThat(Point.first(FALSE).next(FALSE).move()).isEqualTo(1),
                () -> assertThat(Point.first(FALSE).next(TRUE).move()).isEqualTo(2)
        );
    }

    @DisplayName("Point 인스턴스가 부적절한 값 입력시 예외처리 여부 테스트")
    @Test
    void 검증_부적절한_값() {
        assertThatThrownBy(()-> Point.first(TRUE).next(TRUE))
                .isInstanceOf(IllegalBooleanArgumentsException.class)
                .hasMessage("(true, true)는 알맞은 boolean 타입의 인자값이 아닙니다.");
    }

    @DisplayName("Point 인스턴스가 이전이 TRUE 일때, 다음 Point를 반환하는 기능 테스트")
    @Test
    void 기능_다음_포인트_반환_이전이_TRUE() {
        assertThat(Point.first(TRUE).next().move()).isEqualTo(0);
    }


//    @DisplayName("Point 인스턴스가 오른쪽으로 이동하는지 테스트")
//    @Test
//    void 기능_오른쪽_이동() {
//        // given
//        int position = 1;
//        int executed = 2;
//        Direction right = Direction.first(true);
//
//        // when
//        Point point = Point.from(position, right);
//
//        // then
//        assertThat(point.move()).isEqualTo(executed);
//    }
//
//    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 테스트")
//    @Test
//    void 기능_왼쪽_이동() {
//        // given
//        int position = 1;
//        int executed = 0;
//        Direction left = Direction.first(true).next(false);
//
//        // when
//        Point point = Point.from(position, left);
//
//        // then
//        assertThat(point.move()).isEqualTo(executed);
//    }
//
//
//    @DisplayName("Point 인스턴스가 그대로 아래로 이동하는지 테스트")
//    @Test
//    void 기능_아래로_이동() {
//        // given
//        int position = 1;
//        int executed = 1;
//        Direction pass = Direction.first(false);
//
//        // when
//        Point point = Point.from(position, pass);
//
//        // then
//        assertThat(point.move()).isEqualTo(executed);
//    }


//    @Test
//    public void first() {
//        assertThat(Point.first(TRUE).move(), is(1));
//        assertThat(Point.first(FALSE).move(), is(0));
//    }
//
//    @Test
//    public void next_stay() {
//        Point second = Point.first(FALSE).next(FALSE);
//        assertThat(second.move(), is(1));
//    }
//
//    @Test
//    public void next_left() {
//        Point second = Point.first(TRUE).next(FALSE);
//        assertThat(second.move(), is(0));
//    }
//
//    @Test
//    public void next_right() {
//        Point second = Point.first(FALSE).next(TRUE);
//        assertThat(second.move(), is(2));
//    }
//
//    @Test
//    public void next() {
//        Point second = Point.first(TRUE).next();
//        assertThat(second.move(), is(0));
//    }


}