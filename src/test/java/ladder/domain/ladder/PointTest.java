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

    @DisplayName("Point 인스턴스가 제자리로 이동하는지 테스트")
    @Test
    public void 기능_제자리_이동() {
        Point point = Point.first(FALSE);
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    public void 기능_왼쪽으로_이동() {
        Point point = Point.first(TRUE).last();
        assertThat(point.move()).isEqualTo(0);
    }

    @DisplayName("Point 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    public void 기능_오른쪽으로_이동() {
        Point point = Point.first(TRUE);
        assertThat(point.move()).isEqualTo(1);
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
        assertThat(Point.first(TRUE).next(()-> false).move()).isEqualTo(0);
    }

}