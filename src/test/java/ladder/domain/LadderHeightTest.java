package ladder.domain;

import ladder.exception.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {

    @DisplayName("잘못된 생성 시도")
    @Test
    void invalid() {
        assertThatThrownBy(() -> new LadderHeight(-1))
                .isInstanceOf(InvalidLadderHeightException.class);
    }
}
