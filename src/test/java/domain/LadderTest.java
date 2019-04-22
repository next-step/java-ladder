package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void LadderConfig에_맞춰_사다리를_생성한다() {
        Ladder ladder = new Ladder(new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.POOR));
        assertThat(ladder.getLines()).hasSize(5);

        ladder = new Ladder(new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.FAIR));
        assertThat(ladder.getLines()).hasSize(10);

        ladder = new Ladder(new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.GOOD));
        assertThat(ladder.getLines()).hasSize(20);
    }
}
