package ladder.domain.ladder;

import static ladder.domain.ladder.Width.MINIMUM_WIDTH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WidthTest {

    @Test
    @DisplayName("사다리 너비를 생성한다.")
    void Width_FromPlayersCount() {
        assertThat(new Width(MINIMUM_WIDTH))
                .isEqualTo(new Width(MINIMUM_WIDTH));
    }

    @Test
    @DisplayName("사다리 너비가 최소 너비 미만인 경우 예외를 던진다.")
    void Width_LessThanMinimum_Exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Width(MINIMUM_WIDTH - 1));
    }
}
