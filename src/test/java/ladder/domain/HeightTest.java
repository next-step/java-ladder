package ladder.domain;

import ladder.exception.InvalidHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("사다리 높이가 최소값보다 작으면 InvalidHeightException 반환한다.")
    void invalidMin() {
        assertThatThrownBy(() -> new Height(0)).isInstanceOf(InvalidHeightException.class)
                .hasMessage("사다리의 높이는 최소 1 이상이여야 합니다.");
    }
}