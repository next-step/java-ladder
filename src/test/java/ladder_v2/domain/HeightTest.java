package ladder_v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("Ladder는 최소 1개의 Line을 가져야 한다.")
    void testHeight() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(0);
        });
    }
}
