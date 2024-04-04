package ladder.domain.ladder;

import static ladder.domain.ladder.Height.MINIMUM_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    @DisplayName("사다리 높이를 생성한다.")
    void Height() {
        final Height height = new Height(MINIMUM_HEIGHT);

        assertThat(height.value())
                .isEqualTo(MINIMUM_HEIGHT);
    }

    @Test
    @DisplayName("사다리 높이가 최소 높이 미만인 경우 예외를 던진다.")
    void Height_LessThanMinimum_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Height(MINIMUM_HEIGHT - 1));
    }
}
