package step4;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Bridge;
import step4.domain.Height;
import step4.domain.Line;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @Test
    @DisplayName("라인의 높이와 Bridges의 개수는 동일한지 검증")
    void validateIsSame() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(List.of(new Bridge(false), new Bridge(false)), new Height(1)));
    }
}