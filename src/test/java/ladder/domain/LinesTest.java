package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinesTest {

    @DisplayName("참가자 수와 사다리 높이를 전달하면 Lines 객체를 생성한다.")
    @Test
    void linesTest() {
        assertThat(new Lines(3, 3)).isInstanceOf(Lines.class);
    }
}
