package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @Test
    @DisplayName("사람은 2명 미만일 수 없다")
    public void invalidName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(1));
    }
}