package ladder.domain;

import ladder.ladderexceptions.InvalidLayoutException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {

    @Test
    @DisplayName("허용되지 않은 상태에 대한 생성 테스트")
    void testInstance() {
        new Point(false, false);
        new Point(false, true);
        new Point(true, false);

        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(InvalidLayoutException.class);
    }
}
