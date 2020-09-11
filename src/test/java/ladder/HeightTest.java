package ladder;

import ladder.domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = 0)
    @DisplayName("사다리 높이가 최소보다 낮을 경우(1보다)")
    public void minimumHeights(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리는 1개가 최소입니다.");
    }

    @Test
    @DisplayName("사다리 높이 값 가져오는지")
    public void getHeightsCorrect() {
        Height height = new Height(2);
        assertThat(height.getHeight()).isEqualTo(2);
    }

}
