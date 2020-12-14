package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {

    @Test
    @DisplayName("높이가 최소값을 넘지 못하는 경우 IllegalArgumentException 발생")
    void lines_heightError_throwIllegalArgumentException() {
        assertThatThrownBy(() -> new Lines(GameSetup.of(5,0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리의 높이는 최소 1개 이상이어야 합니다.");
    }
}
