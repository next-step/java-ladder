package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    @DisplayName("Line은 최소 2개의 Point를 가져야 한다.")
    void createLineWithException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(1));
    }



}
