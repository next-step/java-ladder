package nextstep.ladder.domain.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightTest {

    @Test
    public void LadderHeight_생성테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderHeight(0));
    }
}