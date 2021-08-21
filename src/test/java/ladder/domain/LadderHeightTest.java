package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderHeightTest {

    @DisplayName("생성")
    @Test
    void create() {
        LadderHeight ladderHeight = new LadderHeight(1);
        assertThat(ladderHeight).isEqualTo(new LadderHeight(1));
    }

    @DisplayName("height 값이 1보다 작을 경우 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfLadderHeightUnderOne() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LadderHeight(0));
    }
}