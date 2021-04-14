package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;
    private Size size = new Size(5, 6);

    @BeforeEach
    void setUp() {
        ladder = new Ladder(size);
    }

    @Test
    void 사다리를생성() {
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }
}
