package ladder.domain.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderHeightTest {

    @Test
    @DisplayName("사다리의 높이가 1이상이 아니면 예외를 던진다.")
    void createLadderHeight_LessThanOne_ThrowException() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderHeight(0));
    }
}
