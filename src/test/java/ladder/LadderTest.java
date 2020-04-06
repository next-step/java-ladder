package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void generateLadderByCountOfPersonAndLadderMaxHeight() {
        Ladder ladder = new Ladder(4, 5);

        assertThat(ladder.getWidth()).isEqualTo(4);
        assertThat(ladder.getHeight()).isEqualTo(5);
    }
}
