package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LineTest {

    @DisplayName("가로줄이 존재하는지 테스트")
    @Test
    void testLineEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(new ArrayList<>()));
    }
}
