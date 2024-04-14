package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import nextstep.ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("가로라인이 겹치면 IllegalArgumentException이 발생한다.")
    void DUPLICATE_LINE_THEN_EXCEPTION() {
        assertThatIllegalArgumentException().isThrownBy(() -> Line.of(true, true));
    }

    @Test
    @DisplayName("가로라인이 겹치않으면 Exception이 발생하지 않는다.")
    void NO_DUPLICATE_LINE_THEN_NOTHING() {
        assertThatNoException().isThrownBy(() -> Line.of(true, false));
    }
}
