package ladder_v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이는 1 미만의 숫자로 생성할 수 없다.")
    void testHeight() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(0);
        });
    }
}
