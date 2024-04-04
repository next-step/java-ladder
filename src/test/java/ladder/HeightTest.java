package ladder;

import static ladder.Height.MINIMUM_HEIGHT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    @DisplayName("사다리 높이가 최소 높이 미만인 경우 예외를 던진다.")
    void Height_LessThanMinimum_Exception() {
        final int heightLessThanMinimum = MINIMUM_HEIGHT - 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Height(heightLessThanMinimum));
    }
}
