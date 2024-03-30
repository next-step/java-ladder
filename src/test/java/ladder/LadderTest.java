package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    @DisplayName("올바른 조건하에 ladder 생성")
    void check_ladder_gen() {
        new Ladder(3, 5);
    }
}
