package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {

    @Test
    @DisplayName("높이 생성 테스트")
    void createHeightTest() {
        Height height = new Height(5);

        assertThat(height).isEqualTo(new Height(5));
    }
}
