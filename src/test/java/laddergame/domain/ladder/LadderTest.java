package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

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

    @Test
    void 사다리의선들을생성() {
        ladder.makeLink(() -> true);
        ladder.getLines().forEach(line -> {
            assertThat(line.isConnect()).containsAll(Collections.singleton(true));
        });
    }
}
