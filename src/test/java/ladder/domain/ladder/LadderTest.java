package ladder.domain.ladder;

import ladder.domain.enums.Complexity;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {

    @Test
    public void 난이도상의_사다리_높이() {
        Ladder ladder = new Ladder();

        assertThat(ladder.generate(Complexity.HARD, 5)).isEqualTo(20);
    }

    @Test
    public void 난이도중의_사다리_높이() {
        Ladder ladder = new Ladder();

        assertThat(ladder.generate(Complexity.NORMAL, 5)).isEqualTo(10);
    }

    @Test
    public void 난이도하의_사다리_높이() {
        Ladder ladder = new Ladder();

        assertThat(ladder.generate(Complexity.EASY, 5)).isEqualTo(5);
    }
}
