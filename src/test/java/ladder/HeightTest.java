package ladder;

import ladder.domain.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void generateHeightTest() {
        int height = 4;
        Height maxHeight = Height.from(height);

        Assertions.assertThat(maxHeight.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("높이 생성 예외 테스트")
    void generateHeightExceptionTest() {
        int height = 0;

        Assertions.assertThatThrownBy(() -> Height.from(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Height.HEIGHT_UNDER_ZERO);
    }

}
