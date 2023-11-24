package ladder_v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("Ladder는 최소 1개의 Line을 가져야 한다.")
    void createLadderWithException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(0,0));
    }
}
