package ladder_refactor;

import ladder_refactor.domain.Direction;
import ladder_refactor.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class PointTest {

    @Test
    @DisplayName("첫번째 값 이동 결과 테스트")
    public void first() {
        Assertions.assertThat(Point.first(TRUE).move()).isEqualTo(1);
        Assertions.assertThat(Point.first(FALSE).move()).isEqualTo(0);
    }

    @Test
    @DisplayName("두번째 포인트 값이 아래방향일때 move 해도 index 는 똑같다")
    public void next_stay() {
        Point second = new Point(1, Direction.of(FALSE, FALSE));
        Assertions.assertThat(second.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("두번째 Point 가 오른쪽 방향을 가졌을때 다음 포인트의 index는 +1 한다")
    public void next_right() {
        Point second = new Point(1, Direction.of(FALSE, TRUE));
        Assertions.assertThat(second.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("첫번째 Point 가 오른쪽 방향이면 두번째 포인트에서 이동시 index 는 -1 이동한다")
    public void next() {
        Point second = Point.first(TRUE).next();
        Assertions.assertThat(second.move()).isEqualTo(0);
    }
}
