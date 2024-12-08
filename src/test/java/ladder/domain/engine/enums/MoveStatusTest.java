package ladder.domain.engine.enums;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveStatusTest {
    @Test
    @DisplayName("이동상태의 값을 구한다")
    void value() {
        int right = MoveStatus.RIGHT.value();
        int left = MoveStatus.LEFT.value();
        int stop = MoveStatus.STOP.value();

        Assertions.assertThat(right).isEqualTo(1);
        Assertions.assertThat(left).isEqualTo(-1);
        Assertions.assertThat(stop).isEqualTo(0);
    }
}