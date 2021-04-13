package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LadderTest {
    private Ladder ladder;
    private Size size = new Size(5, 6);

    @BeforeEach
    void setUp() {
        ladder = new Ladder(size);
    }

    @Test
    void 사다리를생성() {

    }
}
