package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderWidthTest {

    @DisplayName("생성")
    @Test
    void create() {
        LadderWidth ladderWidth = new LadderWidth(2);
        assertThat(ladderWidth).isEqualTo(new LadderWidth(2));
    }

    @DisplayName("width 값이 2보다 작을 경우 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfLadderWidthUnderTwo() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LadderWidth(1));
    }
}