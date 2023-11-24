package ladder_v2.domain;

import ladder.domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {

    @Test
    @DisplayName("Ladder는 최소 1개의 Line을 가져야 한다.")
    void createLadderWithException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Ladder(0,new Height(0)));
    }
}
