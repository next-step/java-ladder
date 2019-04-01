package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderGeneratorTest {
    @Test
    public void 높이5_참여자5인_사다리() {
        // given
        LadderGenerator ladderGenerator = new RandomLadderGenerator();
        // when
        Ladder ladder = ladderGenerator.generate(5, 5);
        // then
        assertThat(ladder.getNumberOfLines()).isEqualTo(5);
        assertThat(ladder.getCountOfPoints()).isEqualTo(5);
    }
}
