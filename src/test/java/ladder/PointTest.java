package ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {
    @Test
    @DisplayName("Point 값에 음수가 들어갈 수 없습니다.")
    void pointNegativeValueTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Point(-1))
                .withMessage("음수 지점은 불가능합니다.");
    }
}
