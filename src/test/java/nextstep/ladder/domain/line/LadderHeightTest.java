package nextstep.ladder.domain.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightTest {

    @Test
    public void Invalid_사다리높이() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(0));
    }
}