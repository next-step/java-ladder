package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 난이도에_따라_높이가_다르다() {
        Ladder ladder = new Ladder(new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.POOR));
        assertThat(ladder.getLines()).hasSize(5);

        ladder = new Ladder(new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.FAIR));
        assertThat(ladder.getLines()).hasSize(10);

        ladder = new Ladder(new DifficultyLadderConfig(5, DifficultyLadderConfig.Difficulty.GOOD));
        assertThat(ladder.getLines()).hasSize(20);
    }
}
