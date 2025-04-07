package nextstep.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("선은 연속으로 true 값을 가질 수 없다.")
    public void checkInvalidLine() {
        assertThatThrownBy(() -> new Line(Arrays.asList(true, true)))
                .isInstanceOf(RuntimeException.class);
    }

}