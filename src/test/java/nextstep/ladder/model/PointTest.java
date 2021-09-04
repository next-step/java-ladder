package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointTest {
    @DisplayName("사용중인 구멍을 다시 사용요청할때")
    @Test
    public void tryToUseUsedPoint() {
        //given
        Point point = new Point();
        point.use(2);

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> point.use(3));
    }

    @DisplayName("음수 값을 사용목표로 정할 때.")
    @Test
    public void setNegativeValue() {
        //given
        Point point = new Point();
        int goal = -2;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> point.use(goal));
    }

    @DisplayName("다음 이동값 테스트")
    @Test
    public void moveHorizontalTest() {
        //given
        int pos = 1;
        int goal = 2;
        Point point = new Point();
        point.use(goal);

        //when
        int next = point.moveHorizontal(pos);

        //then
        assertThat(goal).isEqualTo(next);
    }

    @DisplayName("수평 이동 안할 시 테스트")
    @Test
    public void notMoveHorizontalTest() {
        //given
        int pos = 1;
        Point point = new Point();

        //when
        int next = point.moveHorizontal(pos);

        //then
        assertThat(pos).isEqualTo(next);
    }
}
