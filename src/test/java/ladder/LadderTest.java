package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리_라인_3줄_생성() {
        Ladder ladder = new Ladder(3, 1);
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

}