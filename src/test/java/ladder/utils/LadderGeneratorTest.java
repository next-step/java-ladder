package ladder.utils;

import ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGeneratorTest {
    @Test
    void createLadder() {
        Ladder ladder = LadderGenerator.createLadder(3, 5);

        assertThat(ladder.getLines()).hasSize(5);
        ladder.getLines()
                .forEach(line -> assertThat(line.getPoints()).hasSize(3));
    }
}
