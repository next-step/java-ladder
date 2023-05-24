package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @Test
    @DisplayName("높이는 1 미만일 수 없다")
    public void invalidName() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(0, 4));
    }
}