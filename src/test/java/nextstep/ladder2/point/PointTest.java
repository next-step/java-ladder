package nextstep.ladder2.point;

import nextstep.ladder2.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        Point point = new Point(5, 10);
        assertThat(point.index()).isEqualTo(5);
    }

    @Test
    @DisplayName("포인트 인덱스 범위 체크(음수 불가능)")
    void create_인덱스_음수_불가능() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Point(-5, 10)
        ).withMessageContaining("유효");
    }

    @Test
    @DisplayName("포인트 인덱스 범위 체크(MAX_INDEX 보다 클수 없다.)")
    void create_인덱스_MAX_INDEX_초과_불가능() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Point(11, 10)
        ).withMessageContaining(ErrorMessage.INVALID_INDEX.message());
    }

    @Test
    @DisplayName("포인트 오른쪽 이동")
    void moveRightTest() {
        Point point = new Point(3, 5);
        assertThat(point.right().index()).isEqualTo(4);
    }

    @Test
    @DisplayName("포인트 왼쪽 이동")
    void moveLeftTest() {
        Point point = new Point(3, 5);
        assertThat(point.left().index()).isEqualTo(2);
    }

    @Test
    @DisplayName("MAX 위치에서 오른쪽이동 불가능")
    void cannotMoveAtMaxTest() {
        Point point = new Point(5, 5);
        assertThat(point.right()).isEqualTo(Point.INVALID_POINT);
    }

    @Test
    @DisplayName("MIN 위치에서 왼쪽이동 불가능")
    void cannotMoveAtMinTest() {
        Point point = new Point(0, 5);
        assertThat(point.left()).isEqualTo(Point.INVALID_POINT);
    }

    @Test
    @DisplayName("인덱스가 같으면 같은 객체.")
    void equalsTest(){
        Point point1 = new Point(1,2);
        Point point2 = new Point(1,5);

        assertThat(point1).isEqualTo(point2);
    }
}