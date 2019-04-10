package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리_라인_3줄_생성() {
        Ladder ladder = new Ladder(3, 1, 1);
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사용자와_경품의_수가_다르면_생성_불가() {
        Ladder ladder = new Ladder(3, 1, 2);

    }

}