package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}
