package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName()
    @Test
    void init() {
        Ladder ladder = Ladder.init(3, 4);
        ladder.move(0);
    }
}