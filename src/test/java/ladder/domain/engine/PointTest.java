package ladder.domain.engine;

import ladder.domain.engine.enums.MoveStatus;
import ladder.exception.PointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.engine.Point.NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class PointTest {

    @Test
    @DisplayName("첫번째 포인트를 생성한다")
    void first() {
        Point actual = Point.first(true);
        Point expected = Point.first(true);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("중간 포인트를 생성한다")
    void next() {
        Point actual = Point
                .first(true).next(false);
        Point expected = Point.first(false)
                .next(true).next(false);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("마지막 포인트를 생성한다")
    void last() {
        Point actual = Point.first(false)
                .next(true).last();
        Point expected = Point.first(true).next(false)
                .next(true).last();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("포인트 생성 오류: 라인이 나란히 있을 경우 오류가 발생한다")
    void create_나란히_line_있을_경우_에러() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(PointException.class)
                .hasMessage(NOT_ALLOWED_CONSECUTIVE_LINE_MESSAGE);
    }

    @Test
    @DisplayName("현재 포인트를 출력한다")
    void getCurrent() {
        // f t f f
        Point first = Point.first(true);
        Point next1 = first.next(false);
        Point next2 = next1.next(false);

        //  fir ne1 ne2
        // f | t | f | f
        boolean firstCurrent = first.getRight();
        boolean firstCurrentExpected = true;

        boolean next1Current = next1.getRight();
        boolean next1CurrentExpected = false;

        boolean next2Current = next2.getRight();
        boolean next2CurrentExpected = false;

        assertThat(firstCurrent).isEqualTo(firstCurrentExpected);
        assertThat(next1Current).isEqualTo(next1CurrentExpected);
        assertThat(next2Current).isEqualTo(next2CurrentExpected);
    }

    @Test
    @DisplayName("우측 이동")
    void move_우측() {
        // (f t)
        Point first = Point.first(true);
        MoveStatus actualFirst = first.move();
        MoveStatus expectedFirst = MoveStatus.RIGHT;

        assertThat(actualFirst).isEqualTo(expectedFirst);
    }

    @Test
    @DisplayName("좌측 이동")
    void move_좌측() {
        // f (t f)
        Point first = Point.first(true);
        Point next1 = first.next(false);

        MoveStatus actualNext1 = next1.move();
        MoveStatus expectedNext1 = MoveStatus.LEFT;

        assertThat(actualNext1).isEqualTo(expectedNext1);
    }

    @Test
    @DisplayName("이동 없음")
    void move_이동_없음() {
        // f t (f f)
        Point first = Point.first(true);
        Point next1 = first.next(false);
        Point next2 = next1.next(false);

        MoveStatus actualNext2 = next2.move();
        MoveStatus expectedNext2 = MoveStatus.STOP;

        assertThat(actualNext2).isEqualTo(expectedNext2);
    }
}